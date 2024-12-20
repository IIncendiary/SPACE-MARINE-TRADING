package com.example.PlanetShipsProject.service;

import com.example.PlanetShipsProject.Mapper.PlanetMapper;
import com.example.PlanetShipsProject.Mapper.PlanetResourceMapper;
import com.example.PlanetShipsProject.Mapper.SpaceShipMapper;
import com.example.PlanetShipsProject.dto.PlanetDTO;
import com.example.PlanetShipsProject.dto.SpaceShipDTO;
import com.example.PlanetShipsProject.exceptions.*;
import com.example.PlanetShipsProject.model.Planet;
import com.example.PlanetShipsProject.model.PlanetResource;
import com.example.PlanetShipsProject.model.SpaceShip;
import com.example.PlanetShipsProject.repository.PlanetRepository;
import com.example.PlanetShipsProject.repository.SpaceShipRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@Service
@RequiredArgsConstructor
public class SpaceShipService {
    private final SpaceShipRepository spaceShipRepository;
    private final SpaceShipMapper spaceShipMapper;
    private final PlanetMapper planetMapper;
    private final PlanetResourceMapper planetResourceMapper;
    private final PlanetRepository planetRepository;

    @Transactional
    public List<SpaceShipDTO> findAllShips(){
        return spaceShipRepository.findAll().stream().map(spaceShipMapper::spaceShipEntityToDTO).toList();
    }

    @Transactional
    public void createSpaceShip(SpaceShipDTO spaceShipDTO){
        spaceShipDTO.setShipCurrentCapacity(0D);
        spaceShipRepository.save(spaceShipMapper.spaceShipDTOToEntity(spaceShipDTO));
    }

    public SpaceShipDTO getSpaceShipById(Long id){
        SpaceShip spaceShip = spaceShipRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Нема корабля с индификатором "+id));
        return spaceShipMapper.spaceShipEntityToDTO(spaceShip);
    }

    @Transactional
    public void deleteSpaceShipById(Long id){
        spaceShipRepository.deleteById(id);
    }

    @Transactional
    public void updateSpaceShip(Long spaceShipId, SpaceShipDTO updateSpaceShipDT0){
        SpaceShip exsistingSpaceShip = spaceShipMapper.spaceShipDTOToEntity(getSpaceShipById(spaceShipId));
        SpaceShip updateSpaceShip = spaceShipMapper.spaceShipDTOToEntity(updateSpaceShipDT0);
        exsistingSpaceShip.setShipCapacity(updateSpaceShip.getShipCapacity());
        exsistingSpaceShip.setShipName(updateSpaceShip.getShipName());
        exsistingSpaceShip.setShipCapacity(updateSpaceShip.getShipCapacity());
        exsistingSpaceShip.setCurrentShipFuel(updateSpaceShip.getCurrentShipFuel());
        exsistingSpaceShip.setCurrentPlanet(updateSpaceShip.getCurrentPlanet());
        exsistingSpaceShip.setSpaceShipGoldAmount(updateSpaceShip.getSpaceShipGoldAmount());
        exsistingSpaceShip.setCurrentSpaceShipResource(updateSpaceShip.getCurrentSpaceShipResource());
        spaceShipRepository.save(exsistingSpaceShip);
    }

    @Transactional
    public SpaceShipDTO moveSpaceShip(Long spaceShipId, PlanetDTO targetPlanet){
        SpaceShip exsistingSpaceShip = spaceShipMapper.spaceShipDTOToEntity(getSpaceShipById(spaceShipId));
        if (exsistingSpaceShip.getCurrentShipFuel()<10) throw new LowFuelException("Не хватает топлива");
        exsistingSpaceShip.setCurrentShipFuel(exsistingSpaceShip.getCurrentShipFuel()-10);
        exsistingSpaceShip.setCurrentPlanet(planetMapper.planetDTOtoEntity(targetPlanet));
        return spaceShipMapper.spaceShipEntityToDTO(spaceShipRepository.save(exsistingSpaceShip));
    }

    @Transactional
    public SpaceShipDTO refuelSpaceShip(Long spaceShipId, Double amountOfRefuel){
        SpaceShip exsistingSpaceShip = spaceShipMapper.spaceShipDTOToEntity(getSpaceShipById(spaceShipId));
        //Planet currentPlanet = planetMapping.planetDtoToEntity(planetService.getPlanetById(currentPlanetId));
        //Planet currentPlanet = planetMapper.planetDtoToEntity(planetService.getPlanetById(exsistingSpaceShip.getCurrentPlanet()));
        Planet currentPlanet = exsistingSpaceShip.getCurrentPlanet();
        if ((exsistingSpaceShip.getCurrentShipFuel()+amountOfRefuel<exsistingSpaceShip.getSpaceShipFuelTank())) throw new OutOfBounderFuelTankException("Вы пытаетесь залить болше топлива чем можете");
        if ((exsistingSpaceShip.getSpaceShipGoldAmount()<amountOfRefuel*currentPlanet.getFuelPrice())) throw new OutOfGoldExeption("Не хватает денег на заправку");
        exsistingSpaceShip.setCurrentShipFuel(exsistingSpaceShip.getCurrentShipFuel()+amountOfRefuel);
        exsistingSpaceShip.setSpaceShipGoldAmount(exsistingSpaceShip.getSpaceShipGoldAmount()-(amountOfRefuel*currentPlanet.getFuelPrice()));
        return spaceShipMapper.spaceShipEntityToDTO(spaceShipRepository.save(exsistingSpaceShip));
    }

    @Transactional
    public SpaceShipDTO resourceLoad(Long spaceShipDTOid, Double amountOfResourceToLoad){
        SpaceShip exsistingSpaceShip = spaceShipMapper.spaceShipDTOToEntity(getSpaceShipById(spaceShipDTOid));
       // Planet currentPlanet = planetMapping.planetDtoToEntity(planetService.getPlanetById(currentPlanetId));
        //Planet currentPlanet = planetMapper.planetDtoToEntity(planetService.getPlanetById(exsistingSpaceShip.getCurrentPlanetID()));
        Planet currentPlanet = exsistingSpaceShip.getCurrentPlanet();
            if (exsistingSpaceShip.getShipCapacity()==0){
            if (exsistingSpaceShip.getShipCapacity()<amountOfResourceToLoad) throw new OutOfSpaceShipCapacity("Вы пытаетесь загрузить больше ресурса чем можете взять");
            exsistingSpaceShip.setShipCapacity(exsistingSpaceShip.getShipCapacity()+amountOfResourceToLoad);
        }
        else if (exsistingSpaceShip.getShipCapacity()>0){
            if (exsistingSpaceShip.getShipCapacity()<amountOfResourceToLoad) throw new OutOfSpaceShipCapacity("Вы пытаетесь загрузить больше ресурса чем можете взять");
            if (!exsistingSpaceShip.getCurrentSpaceShipResource().equals(currentPlanet.getPlanetResource())) throw new DifferentResourcesException("Вы пытаетесь загрузить разные ресурсы");
            exsistingSpaceShip.setShipCapacity(exsistingSpaceShip.getShipCapacity()+amountOfResourceToLoad);
        }
        return  spaceShipMapper.spaceShipEntityToDTO(spaceShipRepository.save(exsistingSpaceShip));
    }

    @Transactional
    public SpaceShipDTO sellResource(Long spaceShipId, Double amountOfResourceToSell){
        SpaceShip exsistingSpaceShip = spaceShipMapper.spaceShipDTOToEntity(getSpaceShipById(spaceShipId));
        if ((exsistingSpaceShip.getShipCapacity()-amountOfResourceToSell<0)) throw new OutOfSpaceShipCapacity("Вы пытаетесь продать больше ресурса чем можете взять");
        PlanetResource planetResource = exsistingSpaceShip.getCurrentSpaceShipResource();
        switch (planetResource.getRarity()){
            case 'S': exsistingSpaceShip.setSpaceShipGoldAmount(exsistingSpaceShip.getSpaceShipGoldAmount()+amountOfResourceToSell*100);
            case 'A': exsistingSpaceShip.setSpaceShipGoldAmount(exsistingSpaceShip.getSpaceShipGoldAmount()+amountOfResourceToSell*20);
            case 'B': exsistingSpaceShip.setSpaceShipGoldAmount(exsistingSpaceShip.getSpaceShipGoldAmount()+amountOfResourceToSell*15);
            case 'C': exsistingSpaceShip.setSpaceShipGoldAmount(exsistingSpaceShip.getSpaceShipGoldAmount()+amountOfResourceToSell*10);
            case 'D': exsistingSpaceShip.setSpaceShipGoldAmount(exsistingSpaceShip.getSpaceShipGoldAmount()+amountOfResourceToSell*5);
        }
        return spaceShipMapper.spaceShipEntityToDTO(spaceShipRepository.save(exsistingSpaceShip));
    }
}

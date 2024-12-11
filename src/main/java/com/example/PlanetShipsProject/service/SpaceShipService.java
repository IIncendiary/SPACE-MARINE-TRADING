package com.example.PlanetShipsProject.service;
import com.example.PlanetShipsProject.Mapper.PlanetMapping;
import com.example.PlanetShipsProject.Mapper.SpaceShipMapping;
import com.example.PlanetShipsProject.dto.SpaceShipDTO;
import com.example.PlanetShipsProject.exceptions.*;
import com.example.PlanetShipsProject.model.Planet;
import com.example.PlanetShipsProject.model.SpaceShip;
import com.example.PlanetShipsProject.repository.SpaceShipRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
@RequiredArgsConstructor
public class SpaceShipService {
    private final SpaceShipRepository spaceShipRepository;
    private final PlanetService planetService;
    private final SpaceShipMapping spaceShipMapping;
    private final PlanetMapping planetMapping;

    @Transactional
    public List<SpaceShipDTO> findAllShips(){
        List<SpaceShip> spaceShipList = spaceShipRepository.findAll();
        return spaceShipList.stream().map(spaceShipMapping::spaceShipEntityToDto).collect(Collectors.toList());
    }

    @Transactional
    public void createSpaceShip(SpaceShipDTO spaceShipDTO){
        spaceShipRepository.save(spaceShipMapping.spaceShipDtoToEntity(spaceShipDTO));
    }

    public SpaceShipDTO getSpaceShipById(Long id){
        SpaceShip spaceShip = spaceShipRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Нема корабля с индификатором "+id));
        return spaceShipMapping.spaceShipEntityToDto(spaceShip);
    }

    @Transactional
    public void deleteSpaceShipById(Long id){
        spaceShipRepository.deleteById(id);
    }

    @Transactional
    public void updateSpaceShip(Long spaceShipId, SpaceShipDTO updateSpaceShipDT0){
        SpaceShip exsistingSpaceShip = spaceShipMapping.spaceShipDtoToEntity(getSpaceShipById(spaceShipId));
        SpaceShip updateSpaceShip = spaceShipMapping.spaceShipDtoToEntity(updateSpaceShipDT0);
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
    public SpaceShipDTO moveSpaceShip(Long spaceShipId, Long planetId){
        SpaceShip exsistingSpaceShip = spaceShipMapping.spaceShipDtoToEntity(getSpaceShipById(spaceShipId));
        Planet targetPlanet = planetMapping.planetDtoToEntity(planetService.getPlanetById(planetId));
        if (exsistingSpaceShip.getCurrentShipFuel()<10) throw new LowFuelException("Не хватает топлива");
        exsistingSpaceShip.setCurrentShipFuel(exsistingSpaceShip.getCurrentShipFuel()-10);
        exsistingSpaceShip.setCurrentPlanet(targetPlanet);
        return spaceShipMapping.spaceShipEntityToDto(spaceShipRepository.save(exsistingSpaceShip));
    }

    @Transactional
    public SpaceShipDTO refuelSpaceShip(Long spaceShipId, Long currentPlanetId, Double amountOfRefuel){
        SpaceShip exsistingSpaceShip = spaceShipMapping.spaceShipDtoToEntity(getSpaceShipById(spaceShipId));
        Planet currentPlanet = planetMapping.planetDtoToEntity(planetService.getPlanetById(currentPlanetId));
        if ((exsistingSpaceShip.getCurrentShipFuel()+amountOfRefuel<exsistingSpaceShip.getSpaceShipFuelTank())) throw new OutOfBounderFuelTankException("Вы пытаетесь залить болше топлива чем можете");
        if ((exsistingSpaceShip.getSpaceShipGoldAmount()<amountOfRefuel*currentPlanet.getFuelPrice())) throw new OutOfGoldExeption("Не хватает денег на заправку");
        exsistingSpaceShip.setCurrentShipFuel(exsistingSpaceShip.getCurrentShipFuel()+amountOfRefuel);
        exsistingSpaceShip.setSpaceShipGoldAmount(exsistingSpaceShip.getSpaceShipGoldAmount()-(amountOfRefuel*currentPlanet.getFuelPrice()));
        return spaceShipMapping.spaceShipEntityToDto(spaceShipRepository.save(exsistingSpaceShip));
    }

    @Transactional
    public SpaceShipDTO resourceLoad(SpaceShipDTO spaceShipDTO, Long currentPlanetId, Double amountOfResourceToLoad){
        SpaceShip exsistingSpaceShip = spaceShipMapping.spaceShipDtoToEntity(spaceShipDTO);
        Planet currentPlanet = planetMapping.planetDtoToEntity(planetService.getPlanetById(currentPlanetId));
            if (exsistingSpaceShip.getShipCapacity()==0){
            if (exsistingSpaceShip.getShipCapacity()<amountOfResourceToLoad) throw new OutOfSpaceShipCapacity("Вы пытаетесь загрузить больше ресурса чем можете взять");
            exsistingSpaceShip.setShipCapacity(exsistingSpaceShip.getShipCapacity()+amountOfResourceToLoad);
        }
        else if (exsistingSpaceShip.getShipCapacity()>0){
            if (exsistingSpaceShip.getShipCapacity()<amountOfResourceToLoad) throw new OutOfSpaceShipCapacity("Вы пытаетесь загрузить больше ресурса чем можете взять");
            if (!exsistingSpaceShip.getCurrentSpaceShipResource().equals(currentPlanet.getPlanetResource())) throw new DifferentResourcesException("Вы пытаетесь загрузить разные ресурсы");
            exsistingSpaceShip.setShipCapacity(exsistingSpaceShip.getShipCapacity()+amountOfResourceToLoad);
        }
        return  spaceShipMapping.spaceShipEntityToDto(spaceShipRepository.save(exsistingSpaceShip));
    }

    @Transactional
    public SpaceShipDTO sellResource(Long spaceShipId, Double amountOfResourceToSell){
        SpaceShip exsistingSpaceShip = spaceShipMapping.spaceShipDtoToEntity(getSpaceShipById(spaceShipId));
        if ((exsistingSpaceShip.getShipCapacity()-amountOfResourceToSell<0)) throw new OutOfSpaceShipCapacity("Вы пытаетесь продать больше ресурса чем можете взять");
        switch (exsistingSpaceShip.getCurrentSpaceShipResource().getRarity()){
            case 'S': exsistingSpaceShip.setSpaceShipGoldAmount(exsistingSpaceShip.getSpaceShipGoldAmount()+amountOfResourceToSell*100);
            case 'A': exsistingSpaceShip.setSpaceShipGoldAmount(exsistingSpaceShip.getSpaceShipGoldAmount()+amountOfResourceToSell*20);
            case 'B': exsistingSpaceShip.setSpaceShipGoldAmount(exsistingSpaceShip.getSpaceShipGoldAmount()+amountOfResourceToSell*15);
            case 'C': exsistingSpaceShip.setSpaceShipGoldAmount(exsistingSpaceShip.getSpaceShipGoldAmount()+amountOfResourceToSell*10);
            case 'D': exsistingSpaceShip.setSpaceShipGoldAmount(exsistingSpaceShip.getSpaceShipGoldAmount()+amountOfResourceToSell*5);
        }
        return spaceShipMapping.spaceShipEntityToDto(spaceShipRepository.save(exsistingSpaceShip));
    }
}

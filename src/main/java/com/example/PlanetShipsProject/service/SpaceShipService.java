package com.example.PlanetShipsProject.service;
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
@Data
@Service
@RequiredArgsConstructor
public class SpaceShipService {
    private final SpaceShipRepository spaceShipRepository;
    private final PlanetService planetService;
    private final SpaceShipMapping spaceShipMapping;
    @Transactional
    public List<SpaceShip> findAllShips(){
        return spaceShipRepository.findAll();
    }

    @Transactional
    public SpaceShipDTO createSpaceShipDTO(SpaceShipDTO spaceShipDTO){


        return spaceShipMapping.spaceShipEntityToDto(spaceShipRepository.save(exsistingSpaceShip));
    }

    public SpaceShip getSpaceShipById(Long id){
        return spaceShipRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Нема корабля с индификатором "+id));
    }

    @Transactional
    public void deleteSpaceShipById(Long id){
        spaceShipRepository.deleteById(id);
    }

    @Transactional
    public SpaceShip updateSpaceShip(Long id, SpaceShip updateSpaceShip){
        SpaceShip exsistingSpaceShip = getSpaceShipById(id);
        exsistingSpaceShip.setShipCapaticy(updateSpaceShip.getShipCapaticy());
        exsistingSpaceShip.setShipName(updateSpaceShip.getShipName());
        exsistingSpaceShip.setShipCapaticy(updateSpaceShip.getShipCapaticy());
        exsistingSpaceShip.setCurrentShipFuel(updateSpaceShip.getCurrentShipFuel());
        exsistingSpaceShip.setCurrentPlanet(updateSpaceShip.getCurrentPlanet());
        exsistingSpaceShip.setSpaceShipGoldAmount(updateSpaceShip.getSpaceShipGoldAmount());
        exsistingSpaceShip.setCurrentSpaceShipResource(updateSpaceShip.getCurrentSpaceShipResource());
        return spaceShipMapping.spaceShipEntityToDto(spaceShipRepository.save(exsistingSpaceShip));
    }

    @Transactional
    public SpaceShip moveSpaceShip(Long spaceShipId, Long planetId){
        SpaceShip exsistingSpaceShip = getSpaceShipById(spaceShipId);
        Planet targetPlanet = planetService.getPlanetById(planetId);
        if (exsistingSpaceShip.getCurrentShipFuel()<10) throw new LowFuelException("Не хватает топлива");
        exsistingSpaceShip.setCurrentShipFuel(exsistingSpaceShip.getCurrentShipFuel()-10);
        exsistingSpaceShip.setCurrentPlanet(targetPlanet);
        return spaceShipMapping.spaceShipEntityToDto(spaceShipRepository.save(exsistingSpaceShip));
    }

    @Transactional
    public SpaceShip refuelSpaceShip(Long spaceShipId, Long currentPlanetId, Double amountOfRefuel){
        SpaceShip exsistingSpaceShip = getSpaceShipById(spaceShipId);
        Planet currentPlanet = planetService.getPlanetById(currentPlanetId);
        if ((exsistingSpaceShip.getCurrentShipFuel()+amountOfRefuel<exsistingSpaceShip.getSpaceShipFuelTank())) throw new OutOfBounderFuelTankException("Вы пытаетесь залить болше топлива чем можете");
        if ((exsistingSpaceShip.getSpaceShipGoldAmount()<amountOfRefuel*currentPlanet.getFuelPrice())) throw new OutOfGoldExeption("Не хватает денег на заправку");
        exsistingSpaceShip.setCurrentShipFuel(exsistingSpaceShip.getCurrentShipFuel()+amountOfRefuel);
        exsistingSpaceShip.setSpaceShipGoldAmount(exsistingSpaceShip.getSpaceShipGoldAmount()-(amountOfRefuel*currentPlanet.getFuelPrice()));
        return spaceShipMapping.spaceShipEntityToDto(spaceShipRepository.save(exsistingSpaceShip));
    }

    @Transactional
    public SpaceShipDTO resourceLoad(SpaceShipDTO spaceShipDTO, Long currentPlanetId, Double amountOfResourceToLoad){
        SpaceShip exsistingSpaceShip = getSpaceShipById(spaceShipDTO.getId());
        Planet currentPlanet = planetService.getPlanetById(currentPlanetId);
            if (exsistingSpaceShip.getShipCapaticy()==0){
            if (exsistingSpaceShip.getShipCapaticy()<amountOfResourceToLoad) throw new OutOfSpaceShipCapacity("Вы пытаетесь загрузить больше ресурса чем можете взять");
            exsistingSpaceShip.setShipCapaticy(exsistingSpaceShip.getShipCapaticy()+amountOfResourceToLoad);
        }
        else if (exsistingSpaceShip.getShipCapaticy()>0){
            if (exsistingSpaceShip.getShipCapaticy()<amountOfResourceToLoad) throw new OutOfSpaceShipCapacity("Вы пытаетесь загрузить больше ресурса чем можете взять");
            if (!exsistingSpaceShip.getCurrentSpaceShipResource().equals(currentPlanet.getPlanetResource())) throw new DifferentResourcesException("Вы пытаетесь загрузить разные ресурсы");
            exsistingSpaceShip.setShipCapaticy(exsistingSpaceShip.getShipCapaticy()+amountOfResourceToLoad);
        }
        return  spaceShipMapping.spaceShipEntityToDto(spaceShipRepository.save(exsistingSpaceShip));
    }

    @Transactional
    public SpaceShip sellResource(Long spaceShipId, Double amountOfResourceToSell){
        SpaceShip exsistingSpaceShip = getSpaceShipById(spaceShipId);
        if ((exsistingSpaceShip.getShipCapaticy()-amountOfResourceToSell<0)) throw new OutOfSpaceShipCapacity("Вы пытаетесь продать больше ресурса чем можете взять");


        return spaceShipRepository.save(exsistingSpaceShip);
    }
}

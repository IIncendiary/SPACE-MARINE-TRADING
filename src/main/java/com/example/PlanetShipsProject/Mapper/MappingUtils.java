package com.example.PlanetShipsProject.Mapper;

import com.example.PlanetShipsProject.dto.SpaceShipDTO;
import com.example.PlanetShipsProject.model.SpaceShip;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils { public SpaceShipDTO spaceShipEntityToDto(SpaceShip spaceShipEntity){
    SpaceShipDTO spaceShipDTO = new SpaceShipDTO();
    spaceShipDTO.setId(spaceShipEntity.getId());
    spaceShipDTO.setShipName(spaceShipEntity.getShipName());
    spaceShipDTO.setCurrentSpaceShipResource(spaceShipEntity.getCurrentSpaceShipResource());
    spaceShipDTO.setSpaceShipGoldAmount(spaceShipEntity.getSpaceShipGoldAmount());
    spaceShipDTO.setSpaceShipFuelTank(spaceShipEntity.getSpaceShipFuelTank());
    spaceShipDTO.setCurrentPlanet(spaceShipEntity.getCurrentPlanet());
    spaceShipDTO.setShipCapaticy(spaceShipEntity.getShipCapaticy());
    return spaceShipDTO;
}
    public SpaceShip spaceShipEntityToDto(SpaceShipDTO spaceShipDTO){
        SpaceShip spaceShip = new SpaceShip();
        spaceShip.setId(spaceShipDTO.getId());
        spaceShip.setShipName(spaceShipDTO.getShipName());
        spaceShip.setCurrentSpaceShipResource(spaceShipDTO.getCurrentSpaceShipResource());
        spaceShip.setSpaceShipGoldAmount(spaceShipDTO.getSpaceShipGoldAmount());
        spaceShip.setSpaceShipFuelTank(spaceShipDTO.getSpaceShipFuelTank());
        spaceShip.setCurrentPlanet(spaceShipDTO.getCurrentPlanet());
        spaceShip.setShipCapaticy(spaceShipDTO.getShipCapaticy());
        return spaceShip;
    }
}

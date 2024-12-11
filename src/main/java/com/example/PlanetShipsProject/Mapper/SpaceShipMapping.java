package com.example.PlanetShipsProject.Mapper;

import com.example.PlanetShipsProject.dto.SpaceShipDTO;
import com.example.PlanetShipsProject.model.SpaceShip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceShipMapping {
    public SpaceShipDTO spaceShipEntityToDto(SpaceShip spaceShipEntity){
    SpaceShipDTO spaceShipDTO = new SpaceShipDTO();
    spaceShipDTO.setId(spaceShipEntity.getId());
    spaceShipDTO.setShipName(spaceShipEntity.getShipName());
    spaceShipDTO.setCurrentSpaceShipResource(spaceShipEntity.getCurrentSpaceShipResource());
    spaceShipDTO.setSpaceShipGoldAmount(spaceShipEntity.getSpaceShipGoldAmount());
    spaceShipDTO.setSpaceShipFuelTank(spaceShipEntity.getSpaceShipFuelTank());
    spaceShipDTO.setCurrentPlanet(spaceShipEntity.getCurrentPlanet());
    spaceShipDTO.setShipCapacity(spaceShipEntity.getShipCapacity());
    return spaceShipDTO;
}
    public SpaceShip spaceShipDtoToEntity(SpaceShipDTO spaceShipDTO){
        SpaceShip spaceShip = new SpaceShip();
        spaceShip.setId(spaceShipDTO.getId());
        spaceShip.setShipName(spaceShipDTO.getShipName());
        spaceShip.setCurrentSpaceShipResource(spaceShipDTO.getCurrentSpaceShipResource());
        spaceShip.setSpaceShipGoldAmount(spaceShipDTO.getSpaceShipGoldAmount());
        spaceShip.setSpaceShipFuelTank(spaceShipDTO.getSpaceShipFuelTank());
        spaceShip.setCurrentPlanet(spaceShipDTO.getCurrentPlanet());
        spaceShip.setShipCapacity(spaceShipDTO.getShipCapacity());
        return spaceShip;
    }
    public List<SpaceShipDTO> spaceShipListEntityToDTO(List <SpaceShip> spaceShipEntityList){
        return spaceShipEntityList.stream().map(this::spaceShipEntityToDto).toList();
    }
    public List<SpaceShip> spaceShipListDtoToEntity(List<SpaceShipDTO> spaceShipDTOList){
        return spaceShipDTOList.stream().map(this::spaceShipDtoToEntity).toList();
    }
}


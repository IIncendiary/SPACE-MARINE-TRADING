package com.example.PlanetShipsProject.Mapper;

import com.example.PlanetShipsProject.dto.SpaceShipDTO;
import com.example.PlanetShipsProject.model.SpaceShip;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpaceShipMapper {
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
        if (spaceShipEntityList==null){
            return null;
        }
        List<SpaceShipDTO> spaceShipDTOS = new ArrayList<>(spaceShipEntityList.size());
        for (SpaceShip spaceShip:spaceShipEntityList){
            spaceShipDTOS.add(spaceShipEntityToDto(spaceShip));

        }
        return spaceShipDTOS;
    }
    public List<SpaceShip> spaceShipListDtoToEntity(List<SpaceShipDTO> spaceShipDTOList){
        if (spaceShipDTOList==null){
            return null;
        }
        List<SpaceShip> spaceShips = new ArrayList<>(spaceShipDTOList.size());
        for (SpaceShipDTO spaceShipDTO:spaceShipDTOList){
            spaceShips.add(spaceShipDtoToEntity(spaceShipDTO));

        }
        return spaceShips;
    }
}


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
        spaceShipDTO.setCurrentSpaceShipResourceID(spaceShipEntity.getCurrentSpaceShipResourceID());
        spaceShipDTO.setSpaceShipGoldAmount(spaceShipEntity.getSpaceShipGoldAmount());
        spaceShipDTO.setSpaceShipFuelTank(spaceShipEntity.getSpaceShipFuelTank());
        spaceShipDTO.setCurrentPlanetID(spaceShipEntity.getCurrentPlanetID());
        spaceShipDTO.setCurrentShipFuel(spaceShipEntity.getCurrentShipFuel());
        spaceShipDTO.setShipCapacity(spaceShipEntity.getShipCapacity());
        spaceShipDTO.setShipCurrentCapacity(spaceShipEntity.getShipCurrentCapacity());
    return spaceShipDTO;
    }

    public SpaceShip spaceShipDtoToEntity(SpaceShipDTO spaceShipDTO){
        SpaceShip spaceShip = new SpaceShip();
        spaceShip.setId(spaceShipDTO.getId());
        spaceShip.setShipName(spaceShipDTO.getShipName());
        spaceShip.setCurrentSpaceShipResourceID(spaceShipDTO.getCurrentSpaceShipResourceID());
        spaceShip.setSpaceShipGoldAmount(spaceShipDTO.getSpaceShipGoldAmount());
        spaceShip.setSpaceShipFuelTank(spaceShipDTO.getSpaceShipFuelTank());
        spaceShip.setCurrentPlanetID(spaceShipDTO.getCurrentPlanetID());
        spaceShip.setCurrentShipFuel(spaceShipDTO.getCurrentShipFuel());
        spaceShip.setShipCapacity(spaceShipDTO.getShipCapacity());
        spaceShip.setShipCurrentCapacity(spaceShipDTO.getShipCurrentCapacity());
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


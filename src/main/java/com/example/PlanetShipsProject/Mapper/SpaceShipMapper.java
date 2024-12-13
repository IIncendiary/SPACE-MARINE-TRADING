package com.example.PlanetShipsProject.Mapper;

import com.example.PlanetShipsProject.dto.SpaceShipDTO;
import com.example.PlanetShipsProject.model.SpaceShip;
import com.example.PlanetShipsProject.repository.PlanetRepository;
import com.example.PlanetShipsProject.repository.PlanetResourseRepository;
import com.example.PlanetShipsProject.repository.SpaceShipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class SpaceShipMapper {
    private final PlanetResourseRepository planetResourseRepository;
    private final PlanetRepository planetRepository;
    private final SpaceShipRepository shipRepository;


    public SpaceShipDTO spaceShipEntityToDto(SpaceShip spaceShipEntity){
        SpaceShipDTO spaceShipDTO = new SpaceShipDTO();
        spaceShipDTO.setId(spaceShipEntity.getId());
        spaceShipDTO.setShipName(spaceShipEntity.getShipName());
        spaceShipDTO.setCurrentSpaceShipResourceId(spaceShipEntity.getCurrentSpaceShipResource().getId());
        spaceShipDTO.setSpaceShipGoldAmount(spaceShipEntity.getSpaceShipGoldAmount());
        spaceShipDTO.setSpaceShipFuelTank(spaceShipEntity.getSpaceShipFuelTank());
        spaceShipDTO.setCurrentPlanetID(spaceShipEntity.getCurrentPlanet().getId());
        spaceShipDTO.setCurrentShipFuel(spaceShipEntity.getCurrentShipFuel());
        spaceShipDTO.setShipCapacity(spaceShipEntity.getShipCapacity());
        spaceShipDTO.setShipCurrentCapacity(spaceShipEntity.getShipCurrentCapacity());
    return spaceShipDTO;
    }

    public SpaceShip spaceShipDtoToEntity(SpaceShipDTO spaceShipDTO){
        SpaceShip spaceShip = new SpaceShip();
        spaceShip.setId(spaceShipDTO.getId());
        spaceShip.setShipName(spaceShipDTO.getShipName());
        spaceShip.setCurrentSpaceShipResource(planetResourseRepository.getReferenceById(spaceShipDTO.getCurrentSpaceShipResourceId()));
        spaceShip.setSpaceShipGoldAmount(spaceShipDTO.getSpaceShipGoldAmount());
        spaceShip.setSpaceShipFuelTank(spaceShipDTO.getSpaceShipFuelTank());
        spaceShip.setCurrentPlanet(planetRepository.getReferenceById(spaceShipDTO.getCurrentPlanetID()));
        spaceShip.setCurrentShipFuel(spaceShipDTO.getCurrentShipFuel());
        spaceShip.setShipCapacity(spaceShipDTO.getShipCapacity());
        spaceShip.setShipCurrentCapacity(spaceShipDTO.getShipCurrentCapacity());
        return spaceShip;
    }

    public List<Long> spaceShipListEntityToDTO(List <SpaceShip> spaceShipEntityList){
        if (spaceShipEntityList==null){
            return null;
        }
        List<Long> spaceShipDTOS = new ArrayList<>(spaceShipEntityList.size());
        for (SpaceShip spaceShip:spaceShipEntityList){
            spaceShipDTOS.add(spaceShip.getId());
        }
        return spaceShipDTOS;
    }

    public List<SpaceShip> spaceShipListDtoToEntity(List<Long> spaceShipDTOList){
        if (spaceShipDTOList==null){
            return null;
        }
        List<SpaceShip> spaceShips = new ArrayList<>(spaceShipDTOList.size());
        for (Long spaceShipDTO:spaceShipDTOList){
            spaceShips.add(shipRepository.getReferenceById(spaceShipDTO));
        }
        return spaceShips;
    }
}


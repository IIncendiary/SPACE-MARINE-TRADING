package com.example.PlanetShipsProject.Mapper;

import com.example.PlanetShipsProject.dto.PlanetResourceDTO;
import com.example.PlanetShipsProject.model.PlanetResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanetResourceMapper {

    public PlanetResourceDTO planetResourceEntityToDto(PlanetResource planetResource){
        PlanetResourceDTO planetResourceDTO = new PlanetResourceDTO();
        planetResourceDTO.setId(planetResource.getId());
        planetResourceDTO.setName(planetResource.getName());
        planetResourceDTO.setRarity(planetResource.getRarity());
        planetResourceDTO.setListOfPlanets(planetResource.getListOfPlanets());
        planetResourceDTO.setListOfShips(planetResource.getListOfShips());
        return planetResourceDTO;
    }

    public PlanetResource planetResourceDtoToEntity(PlanetResourceDTO planetResourceDTO){
        PlanetResource planetResource = new PlanetResource();
        planetResource.setId(planetResourceDTO.getId());
        planetResource.setName(planetResourceDTO.getName());
        planetResource.setRarity(planetResourceDTO.getRarity());
        planetResource.setListOfPlanets(planetResourceDTO.getListOfPlanets());
        planetResource.setListOfShips(planetResourceDTO.getListOfShips());
        return planetResource;
    }

    public List<PlanetResourceDTO> planetResourceListEntityToDto(List <PlanetResource> planetResourceList){
        if (planetResourceList==null){
            return null;
        }
        List<PlanetResourceDTO> planetResourceDTOS = new ArrayList<>(planetResourceList.size());
        for (PlanetResource planetResource:planetResourceList){
            planetResourceDTOS.add(planetResourceEntityToDto(planetResource));

        }
        return planetResourceDTOS;
    }

    public List<PlanetResource> planetResourceListDtoToEntity(List<PlanetResourceDTO> planetResourceDTOList){
        if (planetResourceDTOList==null){
            return null;
        }
        List<PlanetResource> planetResources = new ArrayList<>(planetResourceDTOList.size());
        for (PlanetResourceDTO planetResourceDTO:planetResourceDTOList){
            planetResources.add(planetResourceDtoToEntity(planetResourceDTO));

        }
        return planetResources;
    }
}

package com.example.PlanetShipsProject.Mapper;

import com.example.PlanetShipsProject.dto.PlanetResourceDTO;
import com.example.PlanetShipsProject.model.Planet;
import com.example.PlanetShipsProject.model.PlanetResource;
import com.example.PlanetShipsProject.model.SpaceShip;
import com.example.PlanetShipsProject.repository.PlanetRepository;
import com.example.PlanetShipsProject.repository.SpaceShipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class PlanetResourceMapper {

    private final PlanetRepository planetRepository;
    private final SpaceShipRepository spaceShipRepository;

    public PlanetResourceDTO planetResourceEntityToDto(PlanetResource planetResource){
        PlanetResourceDTO planetResourceDTO = new PlanetResourceDTO();
        planetResourceDTO.setId(planetResource.getId());
        planetResourceDTO.setName(planetResource.getName());
        planetResourceDTO.setRarity(planetResource.getRarity());
        planetResourceDTO.setListOfPlanetsID(planetResource.getListOfPlanets().stream().map(Planet::getId).toList());
        planetResourceDTO.setListOfShipsID(planetResource.getListOfShips().stream().map(SpaceShip::getId).toList());
        return planetResourceDTO;
    }

    public PlanetResource planetResourceDtoToEntity(PlanetResourceDTO planetResourceDTO){
        PlanetResource planetResource = new PlanetResource();
        planetResource.setId(planetResourceDTO.getId());
        planetResource.setName(planetResourceDTO.getName());
        planetResource.setRarity(planetResourceDTO.getRarity());
        planetResource.setListOfPlanets(planetResourceDTO.getListOfPlanetsID().stream().map(planetRepository::getReferenceById).toList());
        planetResource.setListOfShips(planetResourceDTO.getListOfShipsID().stream().map(spaceShipRepository::getReferenceById).toList());
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

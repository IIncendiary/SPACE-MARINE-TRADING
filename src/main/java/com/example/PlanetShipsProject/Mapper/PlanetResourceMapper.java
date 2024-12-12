package com.example.PlanetShipsProject.Mapper;

import com.example.PlanetShipsProject.dto.PlanetResourceDTO;
import com.example.PlanetShipsProject.model.PlanetResource;
import org.springframework.stereotype.Service;

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
}

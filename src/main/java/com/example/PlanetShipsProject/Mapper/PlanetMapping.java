package com.example.PlanetShipsProject.Mapper;

import com.example.PlanetShipsProject.dto.PlanetDTO;
import com.example.PlanetShipsProject.model.Planet;
import org.springframework.stereotype.Service;

@Service
public class PlanetMapping {
    public PlanetDTO planetEntityToDto(Planet planet){
        PlanetDTO planetDTO = new PlanetDTO();
        planetDTO.setId(planet.getId());
        planetDTO.setName(planet.getName());
        planetDTO.setPlanetResource(planet.getPlanetResource());
        planetDTO.setFuelPrice(planet.getFuelPrice());
        planetDTO.setListOfShips(planet.getListOfShips());
        return planetDTO;
    }
    public Planet planetDtoToEntity(PlanetDTO planetDTO){
        Planet planet = new Planet();
        planet.setId(planetDTO.getId());
        planet.setName(planetDTO.getName());
        planet.setPlanetResource(planetDTO.getPlanetResource());
        planet.setFuelPrice(planetDTO.getFuelPrice());
        planet.setListOfShips(planetDTO.getListOfShips());
        return planet;
    }
}

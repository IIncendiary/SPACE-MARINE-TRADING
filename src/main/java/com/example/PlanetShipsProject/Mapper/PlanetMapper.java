package com.example.PlanetShipsProject.Mapper;

import com.example.PlanetShipsProject.dto.PlanetDTO;
import com.example.PlanetShipsProject.dto.SpaceShipDTO;
import com.example.PlanetShipsProject.model.Planet;
import com.example.PlanetShipsProject.model.SpaceShip;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanetMapper {
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

    public List<PlanetDTO> planetListEntityToDTO(List <Planet> planetEntityList){
        if (planetEntityList==null){
            return null;
        }
        List<PlanetDTO> planetDTOS = new ArrayList<>(planetEntityList.size());
        for (Planet planet:planetEntityList){
            planetDTOS.add(planetEntityToDto(planet));

        }
        return planetDTOS;
    }

    public List<Planet> planetListDtoToEntity(List<PlanetDTO> planetDTOList){
        if (planetDTOList==null){
            return null;
        }
        List<Planet> planets = new ArrayList<>(planetDTOList.size());
        for (PlanetDTO planetDTO:planetDTOList){
            planets.add(planetDtoToEntity(planetDTO));

        }
        return planets;
    }
}

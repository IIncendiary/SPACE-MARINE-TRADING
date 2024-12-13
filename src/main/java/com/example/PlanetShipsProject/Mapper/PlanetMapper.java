package com.example.PlanetShipsProject.Mapper;

import com.example.PlanetShipsProject.dto.PlanetDTO;
import com.example.PlanetShipsProject.model.Planet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanetMapper {

    public PlanetDTO planetEntityToDto(Planet planet){
        PlanetDTO planetDTO = new PlanetDTO();
        planetDTO.setId(planet.getId());
        planetDTO.setName(planet.getName());
        planetDTO.setPlanetResourceID(planet.getPlanetResourceID());
        planetDTO.setFuelPrice(planet.getFuelPrice());
        planetDTO.setListOfShipsId(planet.getListOfShipsId());
        return planetDTO;
    }

    public Planet planetDtoToEntity(PlanetDTO planetDTO){
        Planet planet = new Planet();
        planet.setId(planetDTO.getId());
        planet.setName(planetDTO.getName());
        planet.setPlanetResourceID(planetDTO.getPlanetResourceID());
        planet.setFuelPrice(planetDTO.getFuelPrice());
        planet.setListOfShipsId(planetDTO.getListOfShipsId());
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

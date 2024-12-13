package com.example.PlanetShipsProject.Mapper;

import com.example.PlanetShipsProject.dto.PlanetDTO;
import com.example.PlanetShipsProject.model.Planet;
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

public class PlanetMapper {
    private final PlanetResourseRepository planetResourseRepository;
    private final PlanetRepository planetRepository;
    private final SpaceShipRepository spaceShipRepository;

    public PlanetDTO planetEntityToDto(Planet planet){
        PlanetDTO planetDTO = new PlanetDTO();
        planetDTO.setId(planet.getId());
        planetDTO.setName(planet.getName());
        planetDTO.setPlanetResourceID(planet.getPlanetResource().getId());
        planetDTO.setFuelPrice(planet.getFuelPrice());
        planetDTO.setListOfShipsID(planet.getListOfShips().stream().map(SpaceShip::getId).toList());
        return planetDTO;
    }

    public Planet planetDtoToEntity(PlanetDTO planetDTO){
        Planet planet = new Planet();
        planet.setId(planetDTO.getId());
        planet.setName(planetDTO.getName());
        planet.setPlanetResource(planetResourseRepository.getReferenceById(planetDTO.getPlanetResourceID()));
        planet.setFuelPrice(planetDTO.getFuelPrice());
        planet.setListOfShips(planetDTO.getListOfShipsID().stream().map(spaceShipRepository::getReferenceById).toList());
        return planet;
    }

    public List<Long> planetListEntityToDTO(List <Planet> planetEntityList){
        if (planetEntityList==null){
            return null;
        }
        List<Long> planetDTOS = new ArrayList<>(planetEntityList.size());
        for (Planet planet:planetEntityList){
            planetDTOS.add(planet.getId());
        }
        return planetDTOS;
    }

    public List<Planet> planetListDtoToEntity(List<Long> planetDTOList){
        if (planetDTOList==null){
            return null;
        }
        List<Planet> planets = new ArrayList<>(planetDTOList.size());
        for (Long planetDTOId:planetDTOList){
            planets.add(planetRepository.getReferenceById(planetDTOId));
        }
        return planets;
    }
}

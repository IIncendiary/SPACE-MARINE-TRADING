package com.example.PlanetShipsProject.service;
import com.example.PlanetShipsProject.Mapper.PlanetMapping;
import com.example.PlanetShipsProject.dto.PlanetDTO;
import com.example.PlanetShipsProject.model.Planet;
import com.example.PlanetShipsProject.repository.PlanetRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Data
@RequiredArgsConstructor
@Service
public class PlanetService {
    private final PlanetRepository planetRepository;
    private final PlanetMapping planetMapping;
    public List<Planet> findAllPlanets(){
        return planetRepository.findAll();
    }

    @Transactional
    public void createPlanet(PlanetDTO planetDTO){
       planetRepository.save(planetMapping.planetDtoToEntity(planetDTO));
    }

    public PlanetDTO getPlanetById(Long id){
        Planet planet = planetRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Нема планеты с индификатором "+id));
        return planetMapping.planetEntityToDto(planet);
    }

    @Transactional
    public void deletePlanet (Long id){
        planetRepository.deleteById(id);
    }

    @Transactional
    public PlanetDTO updatePlanet(Long id, PlanetDTO updatePlanetDTO){
        Planet exsistingPlanet = planetMapping.planetDtoToEntity(getPlanetById(id));
        exsistingPlanet.setName(updatePlanetDTO.getName());
        exsistingPlanet.setPlanetResource(updatePlanetDTO.getPlanetResource());
        exsistingPlanet.setFuelPrice(updatePlanetDTO.getFuelPrice());
        return planetMapping.planetEntityToDto(planetRepository.save(exsistingPlanet));
    }

    public PlanetDTO updatePlanetFuelPrice(Long id, Double newFuelPrice){
        Planet exsistingPlanet = planetMapping.planetDtoToEntity(getPlanetById(id));
        exsistingPlanet.setFuelPrice(newFuelPrice);
        return planetMapping.planetEntityToDto(planetRepository.save(exsistingPlanet));
    }
}

0
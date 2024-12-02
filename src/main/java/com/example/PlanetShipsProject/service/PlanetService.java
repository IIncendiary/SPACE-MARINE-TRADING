package com.example.PlanetShipsProject.service;
import com.example.PlanetShipsProject.model.Planet;
import com.example.PlanetShipsProject.repository.PlanetRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Data
@RequiredArgsConstructor
@Service
public class PlanetService {
    private final PlanetRepository planetRepository;

    public List<Planet> findAllPlanets(){
        return planetRepository.findAll();
    }

    @Transactional
    public Planet createPlanet(Planet planet){
        return planetRepository.save(planet);
    }

    public Planet getPlanetById(Long id){
        return planetRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Нема планеты с индификатором "+id));
    }

    @Transactional
    public void deletePlanet (Long id){
        planetRepository.deleteById(id);
    }

    @Transactional
    public Planet updatePlanet(Long id, Planet updatePlanet){
        Planet exsistingPlanet = getPlanetById(id);
        exsistingPlanet.setName(updatePlanet.getName());
        exsistingPlanet.setPlanetResource(updatePlanet.getPlanetResource());
        return planetRepository.save(exsistingPlanet);
    }

    //@Transactional

}


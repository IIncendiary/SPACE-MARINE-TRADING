package com.example.PlanetShipsProject.service;

import com.example.PlanetShipsProject.model.Planet;
import com.example.PlanetShipsProject.repository.PlanetRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlanetService {
    private final PlanetRepository planetRepository;

    public findAllPlanets(Planet planet){
        planetRepository.findAll();
    }
    public createPlanet(Planet planet){
        return planetRepository.save(planet);
    }
    public getPlanetById(Long id){
        return planetRepository.findById(id);
    }
    public deletePlanet (Long id){
        planetRepository.delete(id);
    }

}


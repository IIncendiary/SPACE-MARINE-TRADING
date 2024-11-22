package com.example.PlanetShipsProject.service;

import com.example.PlanetShipsProject.Planet;
import com.example.PlanetShipsProject.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {
    private final PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }
     public List<Planet> getAllPlanets{
        return planetRepository.findAll();
    }
}

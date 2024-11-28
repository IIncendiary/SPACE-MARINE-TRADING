package com.example.PlanetShipsProject.service;

import com.example.PlanetShipsProject.model.Planet;
import com.example.PlanetShipsProject.model.Ship;
import com.example.PlanetShipsProject.repository.ShipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipService {
    private final ShipRepository shipRepository;

    public List<Ship> findAllPlanets(){
        return shipRepository.findAll();
    }
}


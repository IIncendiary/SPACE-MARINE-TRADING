package com.example.PlanetShipsProject.service;

import com.example.PlanetShipsProject.model.Ship;
import com.example.PlanetShipsProject.repository.ShipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShipService {
    private final ShipRepository shipRepository;

    public createShip(Ship ship){
        shipRepository.save(ship);
    }
    public findAllShips (Ship ship){
        shipRepository.findAll();
    }
    public updateShip (Ship ship){

    }

}


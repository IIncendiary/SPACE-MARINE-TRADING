package com.example.PlanetShipsProject.dto;

import com.example.PlanetShipsProject.model.Planet;
import com.example.PlanetShipsProject.model.PlanetResource;
import lombok.Data;

@Data
public class SpaceShipDTO {

    private Long id;

    private String shipName;

    private Double shipCapacity;

    private PlanetResource currentSpaceShipResource;

    private Double currentShipFuel;

    private Double spaceShipGoldAmount;

    private Planet currentPlanet;

    private Double spaceShipFuelTank;
}

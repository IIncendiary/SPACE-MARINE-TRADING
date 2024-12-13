package com.example.PlanetShipsProject.dto;

import com.example.PlanetShipsProject.model.Planet;
import com.example.PlanetShipsProject.model.PlanetResource;
import lombok.Data;

@Data
public class SpaceShipDTO {

    private Long id;

    private String shipName;

    private Double shipCapacity;

    private Double shipCurrentCapacity;

    private Long currentSpaceShipResourceID;

    private Double currentShipFuel;

    private Double spaceShipGoldAmount;

    private Long currentPlanetID;

    private Double spaceShipFuelTank;
}

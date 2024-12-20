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

    private PlanetResourceDTO planetResourceDTO;

    private Double currentShipFuel;

    private Double spaceShipGoldAmount;

    private PlanetDTO currentPlanet;

    private Double spaceShipFuelTank;
}

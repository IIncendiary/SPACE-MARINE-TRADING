package com.example.PlanetShipsProject.dto;

import com.example.PlanetShipsProject.model.Planet;
import com.example.PlanetShipsProject.model.PlanetResource;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class SpaceShipDTO {
    private Long id;
    private String shipName;
    private Double shipCapaticy;
    private PlanetResource currentSpaceShipResource;
    private Double currentShipFuel;
    private Double spaceShipGoldAmount;
    private Planet currentPlanet;
    private Double spaceShipFuelTank;
}

package com.example.PlanetShipsProject.dto;

import com.example.PlanetShipsProject.model.PlanetResource;
import com.example.PlanetShipsProject.model.SpaceShip;
import lombok.Data;

import java.util.List;

@Data
public class PlanetDTO {

    private Long id;

    private String name;

    private PlanetResource planetResource;

    private Double fuelPrice;

    List<SpaceShip> listOfShips;
}

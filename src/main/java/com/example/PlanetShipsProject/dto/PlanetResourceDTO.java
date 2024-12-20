package com.example.PlanetShipsProject.dto;

import lombok.Data;

import java.util.List;
@Data
public class PlanetResourceDTO {

    private Long id;

    private String name;

    private Character rarity;

    List<SpaceShipDTO> listOfShips;

    List<PlanetDTO> listOfPlanets;
}

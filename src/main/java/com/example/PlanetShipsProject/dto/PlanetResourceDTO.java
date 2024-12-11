package com.example.PlanetShipsProject.dto;

import com.example.PlanetShipsProject.model.Planet;
import com.example.PlanetShipsProject.model.SpaceShip;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
@Data
public class PlanetResourceDTO {
    private Long id;
    private String name;
    private Character rarity;
    List<SpaceShip> listOfShips;
    List<Planet> listOfPlanets;
}

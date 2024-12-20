package com.example.PlanetShipsProject.dto;

import com.example.PlanetShipsProject.model.PlanetResource;
import com.example.PlanetShipsProject.model.SpaceShip;
import jakarta.annotation.Nullable;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlanetDTO {

    private Long id;

    private String name;

    private PlanetResourceDTO planetResource;

    private Double fuelPrice;

    List<SpaceShipDTO> listOfShips;
}

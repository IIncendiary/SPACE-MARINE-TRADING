package com.example.PlanetShipsProject.dto;

import com.example.PlanetShipsProject.model.PlanetResource;
import com.example.PlanetShipsProject.model.SpaceShip;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class PlanetDTO {
    private Long id;
    private String name;
    private PlanetResource planetResource;
    private Double distanceFromEarth;
    private Double quanitytyOfResource;
    private Double fuelPrice;

}

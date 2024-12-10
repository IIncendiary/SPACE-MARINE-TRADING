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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private PlanetResource planetResource;
    private Double distanceFromEarth;
    private Double quantytyOfResource;
    private Double fuelPrice;
    @OneToMany
    List<SpaceShip> listOfShips;
}

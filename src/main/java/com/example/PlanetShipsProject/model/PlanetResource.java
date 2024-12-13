package com.example.PlanetShipsProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class PlanetResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Character rarity;

    @OneToMany(mappedBy = "currentSpaceShipResource")
    List<SpaceShip> listOfShips;

    @OneToMany(mappedBy = "planetResource")
    List<Planet> listOfPlanets;
}



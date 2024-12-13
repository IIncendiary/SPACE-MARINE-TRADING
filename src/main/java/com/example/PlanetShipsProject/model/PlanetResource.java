package com.example.PlanetShipsProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany
    List<Long> listOfShipsID;

    @OneToMany
    List<Long> listOfPlanetsID;
}



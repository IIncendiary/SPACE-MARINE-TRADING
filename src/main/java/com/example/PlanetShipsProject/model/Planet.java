package com.example.PlanetShipsProject.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToOne
    private PlanetResource planetResource;
    private Double distanceFromEarth;
    private Double quanitytyOfResource;
}



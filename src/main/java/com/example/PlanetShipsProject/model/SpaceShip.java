package com.example.PlanetShipsProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class SpaceShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shipName;
    private Double shipCapaticy;
    private Double currentShipFuel;
    @ManyToOne
    private Planet currentPlanet;
}

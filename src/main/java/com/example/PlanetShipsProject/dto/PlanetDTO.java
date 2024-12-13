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

    private Long planetResourceID;

    private Double fuelPrice;

    List<Long> listOfShipsID = new ArrayList<>();
}

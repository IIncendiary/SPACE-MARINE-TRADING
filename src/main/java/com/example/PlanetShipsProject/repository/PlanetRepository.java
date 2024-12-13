package com.example.PlanetShipsProject.repository;

import com.example.PlanetShipsProject.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
}

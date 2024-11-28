package com.example.PlanetShipsProject.repository;

import com.example.PlanetShipsProject.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface PlanetRepository extends JpaRepository<Planet, Long> {

}

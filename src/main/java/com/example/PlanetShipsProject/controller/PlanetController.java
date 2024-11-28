package com.example.PlanetShipsProject.controller;

import com.example.PlanetShipsProject.model.Planet;
import com.example.PlanetShipsProject.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("a/pi/planets")
public class PlanetController {
    final PlanetService planetService;
    @Autowired
    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }
    @GetMapping
    public List<Planet> getAllPlanets(){
        return planetService.findAllPlanets();
    }
    @GetMapping("/{id}")
    public Planet getPlanetById(@PathVariable Long id){
        return planetService.getPlanetById(id);
    }
}

package com.example.PlanetShipsProject.controller;

import com.example.PlanetShipsProject.dto.PlanetDTO;
import com.example.PlanetShipsProject.dto.SpaceShipDTO;
import com.example.PlanetShipsProject.model.Planet;
import com.example.PlanetShipsProject.service.PlanetService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/planets")
public class PlanetController {
    final PlanetService planetService;

    @GetMapping("/{planetId}")
    public PlanetDTO getPlanetById(@PathVariable Long planetId){
        return planetService.getPlanetById(planetId);
    }

    @PostMapping ("/create")
    public void createPlanet(@RequestBody PlanetDTO newPlanetDTO){
        planetService.createPlanet(newPlanetDTO);
    }

    @PutMapping("/{planetId}/update")
    public void updatePlanet(@PathVariable Long planetId, @RequestBody PlanetDTO planetDTO){
        planetService.updatePlanet(planetId,planetDTO);
    }

    @DeleteMapping ("/delete/{planetId}")
    public void deletePlanet(@PathVariable Long planetId){
        planetService.deletePlanet(planetId);
    }

    @GetMapping("/all")
    public List<PlanetDTO> getAllPlanets(){
        return planetService.findAllPlanets();
    }

    @PutMapping("/{planetId}/update/fuelprice")
    public void updatePlanetFuelPrice(@PathVariable Long planetId, @RequestBody Double newFuelPrice){
        planetService.updatePlanetFuelPrice(planetId,newFuelPrice);
    }

    @GetMapping("/{planetId}/allspaceships")
    public List<SpaceShipDTO> getAllSpaceShipsOnAPlanet(@PathVariable Long planetId){
        return planetService.getAllSpaceShipsOnAPlanet(planetId);
    }

}

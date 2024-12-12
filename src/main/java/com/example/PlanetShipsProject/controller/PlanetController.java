package com.example.PlanetShipsProject.controller;

import com.example.PlanetShipsProject.dto.PlanetDTO;
import com.example.PlanetShipsProject.dto.SpaceShipDTO;
import com.example.PlanetShipsProject.service.PlanetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/planet")
public class PlanetController {
    private  final PlanetService planetService;

    @GetMapping("/{planetId}")
    public PlanetDTO getPlanetById(@PathVariable Long planetId){
        return planetService.getPlanetById(planetId);
    }

    @PostMapping ()
    public void createPlanet(@RequestBody PlanetDTO newPlanetDTO){
        planetService.createPlanet(newPlanetDTO);
    }

    @PutMapping("/{planetId}")
    public void updatePlanet(@PathVariable Long planetId, @RequestBody PlanetDTO planetDTO){
        planetService.updatePlanet(planetId,planetDTO);
    }

    @DeleteMapping ("/{planetId}")
    public void deletePlanet(@PathVariable Long planetId){
        planetService.deletePlanet(planetId);
    }

    @GetMapping("/all")
    public List<PlanetDTO> getAllPlanets(){
        return planetService.findAllPlanets();
    }

    @PutMapping("/{planetId}/update/{fuelprice}")
    public void updatePlanetFuelPrice(@PathVariable Long planetId, @PathVariable Double newFuelPrice){
        planetService.updatePlanetFuelPrice(planetId,newFuelPrice);
    }

    @GetMapping("/{planetId}/allspaceships")
    public List<SpaceShipDTO> getAllSpaceShipsOnAPlanet(@PathVariable Long planetId){
        return planetService.getAllSpaceShipsOnAPlanet(planetId);
    }

}

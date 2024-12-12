package com.example.PlanetShipsProject.controller;

import com.example.PlanetShipsProject.dto.PlanetDTO;
import com.example.PlanetShipsProject.dto.PlanetResourceDTO;
import com.example.PlanetShipsProject.dto.SpaceShipDTO;
import com.example.PlanetShipsProject.service.PlanetResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planetresources")
@RequiredArgsConstructor
public class PlanetResourceController {
    private final PlanetResourceService planetResourceService;

    @GetMapping("/{planetResourceId}")
    public PlanetResourceDTO getPlanetResourceById(@PathVariable Long planetId){
        return planetResourceService.getPlanetResourceById(planetId);
    }

    @PostMapping("/create")
    public void createPlanetResource(@RequestBody PlanetResourceDTO planetResourceDTO){
        planetResourceService.createPlanetResource(planetResourceDTO);
    }

    @PutMapping("/{planetResourceId}/update")
    public void updatePlanetResource(@PathVariable Long planetId, @RequestBody PlanetResourceDTO planetResourceDTO){
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

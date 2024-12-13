package com.example.PlanetShipsProject.controller;

import com.example.PlanetShipsProject.dto.PlanetDTO;
import com.example.PlanetShipsProject.dto.PlanetResourceDTO;
import com.example.PlanetShipsProject.dto.SpaceShipDTO;
import com.example.PlanetShipsProject.service.PlanetResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planetresource")
@RequiredArgsConstructor
public class PlanetResourceController {
    private final PlanetResourceService planetResourceService;

    @GetMapping("/{planetResourceId}")
    public PlanetResourceDTO getPlanetResourceById(@PathVariable Long planetResourceId){
        return planetResourceService.getPlanetResourceById(planetResourceId);
    }

    @PostMapping()
    public void createPlanetResource(@RequestBody PlanetResourceDTO planetResourceDTO){
        planetResourceService.createPlanetResource(planetResourceDTO);
    }

    @PutMapping("/{planetResourceId}")
    public void updatePlanetResource(@PathVariable Long planetResourceId, @RequestBody PlanetResourceDTO planetResourceDTO){
        planetResourceService.updatePlanetResource(planetResourceId,planetResourceDTO);
    }

    @DeleteMapping ("/{planetResourceId}")
    public void deletePlanet(@PathVariable Long planetResourceId){
        planetResourceService.deletePlanetResource(planetResourceId);
    }

    @GetMapping("/all")
    public List<PlanetResourceDTO> findAllPlanetResources(){
        return planetResourceService.findAllPlanetResources();
    }

    @GetMapping("/{planetResourceId}/allspaceships")
    public List<Long> findAllSpaceShipsCarringThisResource(@PathVariable Long planetResourceId){
        return planetResourceService.findAllSpaceShipsCarringThisResource(planetResourceId);
    }

    @GetMapping("/{planetResourceId}/allplanets")
    public List<Long> findAllPlanetsWithThisResource(@PathVariable Long planetResourceId){
        return planetResourceService.findAllPlanetsWithThisResource(planetResourceId);
    }
}

package com.example.PlanetShipsProject.controller;

import com.example.PlanetShipsProject.model.Planet;
import com.example.PlanetShipsProject.model.SpaceShip;
import com.example.PlanetShipsProject.service.SpaceShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spaceShip")
@RequiredArgsConstructor
public class ShipController {
    private final SpaceShipService spaceShipService;

    @GetMapping("/{spaceShipId}")
    public SpaceShip getSpaceShipById(@PathVariable Long spaceShipId){
        return  spaceShipService.getSpaceShipById(spaceShipId);
    }

    @PostMapping ("/spaceShip/createSpaceShip")
    public SpaceShip createSpaceShip(@RequestBody SpaceShip newSpaceShip){
       return spaceShipService.createSpaceShip(newSpaceShip);
    }

    @PutMapping ("/{spaceShipId}/moveSpaceShip/targetPlanetId")
    public SpaceShip moveSpaceShip(@PathVariable Long spaceShipId, @PathVariable Long targetPlanetId){
        return spaceShipService.moveSpaceShip(spaceShipId,targetPlanetId);
    }

    @PutMapping("/{spaceShipId}/update")
    public  SpaceShip updateSpaceShip(@PathVariable Long spaceShipId, @RequestBody SpaceShip updateSpaceShip){
        return spaceShipService.updateSpaceShip(spaceShipId,updateSpaceShip);
    }

    @DeleteMapping ("/{spaceShipId}/delete")
    public SpaceShip deleteSpaceShip()
}

package com.example.PlanetShipsProject.controller;

import com.example.PlanetShipsProject.dto.SpaceShipDTO;
import com.example.PlanetShipsProject.model.SpaceShip;
import com.example.PlanetShipsProject.service.SpaceShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spaceShip")
@RequiredArgsConstructor
public class ShipController {
    private final SpaceShipService spaceShipService;

    @GetMapping("/{spaceShipId}")
    public SpaceShipDTO getSpaceShipById(@PathVariable Long spaceShipId){
        return  spaceShipService.getSpaceShipById(spaceShipId);
    }

    @PostMapping ("/spaceShip/createSpaceShip")
    public SpaceShipDTO createSpaceShip(@RequestBody SpaceShipDTO newSpaceShip){
       return spaceShipService.createSpaceShip(newSpaceShip);
    }

    @PutMapping ("/{spaceShipId}/moveSpaceShip/targetPlanetId")
    public SpaceShipDTO moveSpaceShip(@PathVariable Long spaceShipId, @PathVariable Long targetPlanetId){
        return spaceShipService.moveSpaceShip(spaceShipId,targetPlanetId);
    }

    @PutMapping("/{spaceShipId}/update")
    public  SpaceShipDTO updateSpaceShip(@PathVariable Long spaceShipId, @RequestBody SpaceShipDTO updateSpaceShip){
        return spaceShipService.updateSpaceShip(spaceShipId ,updateSpaceShip);
    }

    @DeleteMapping ("/{spaceShipId}/delete")
    public void deleteSpaceShipById(@PathVariable  Long spaceShipId){
        spaceShipService.deleteSpaceShipById(spaceShipId);
    }
    @GetMapping("/all")
    public List<SpaceShipDTO> getAllSpaceShips(){
        return spaceShipService.findAllShips();
    }
}

package com.example.PlanetShipsProject.controller;
import com.example.PlanetShipsProject.dto.SpaceShipDTO;
import com.example.PlanetShipsProject.service.PlanetService;
import com.example.PlanetShipsProject.service.SpaceShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spaceShip")
@RequiredArgsConstructor
public class ShipController {
    private final PlanetService planetService;
    private final SpaceShipService spaceShipService;

    @GetMapping("/{spaceShipId}")
    public SpaceShipDTO getSpaceShipById(@PathVariable Long spaceShipId){
        return  spaceShipService.getSpaceShipById(spaceShipId);
    }

    @PostMapping ()
    public void createSpaceShip(@RequestBody SpaceShipDTO newSpaceShipDTO){
       spaceShipService.createSpaceShip(newSpaceShipDTO);
    }

    @PutMapping ("/{spaceShipId}/moveSpaceShip/{targetPlanetId}")
    public SpaceShipDTO moveSpaceShip(@PathVariable Long spaceShipId, @PathVariable Long targetPlanetId){
        return spaceShipService.moveSpaceShip(spaceShipId,planetService.getPlanetById(targetPlanetId));
    }

    @PutMapping("/{spaceShipId}")
    public void updateSpaceShip(@PathVariable Long spaceShipId, @RequestBody SpaceShipDTO updateSpaceShip){
        spaceShipService.updateSpaceShip(spaceShipId ,updateSpaceShip);
    }

    @DeleteMapping ("/{spaceShipId}")
    public void deleteSpaceShipById(@PathVariable  Long spaceShipId){
        spaceShipService.deleteSpaceShipById(spaceShipId);
    }

    @GetMapping("/all")
    public List<SpaceShipDTO> getAllSpaceShips(){
        return spaceShipService.findAllShips();
    }

    @PutMapping ("/{spaceShipId}/loadspaceship/{amountOfResourceToLoad}")
    public SpaceShipDTO resourceLoad(@PathVariable Long spaceShipId, @PathVariable  Double amountOfResourceToLoad ){
        return spaceShipService.resourceLoad(spaceShipId, amountOfResourceToLoad);
    }

    @PutMapping ("/{spaceShipId}/resuelspaceship/{amountOfRefuel}")
    public SpaceShipDTO refuelSpaceShip(@PathVariable Long spaceShipId, @PathVariable Double amountOfRefuel ){
        return spaceShipService.refuelSpaceShip(spaceShipId, amountOfRefuel);
    }

    @PutMapping ("/{spaceShipId}/sellResource/{amountOfResourceToSell}")
    public SpaceShipDTO sellResource(@PathVariable Long spaceShipId, @PathVariable Double amountOfResourceToSell ){
        return spaceShipService.sellResource(spaceShipId, amountOfResourceToSell);
    }
}

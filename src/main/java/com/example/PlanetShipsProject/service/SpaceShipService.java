package com.example.PlanetShipsProject.service;
import com.example.PlanetShipsProject.LowFuelExeption;
import com.example.PlanetShipsProject.model.Planet;
import com.example.PlanetShipsProject.model.SpaceShip;
import com.example.PlanetShipsProject.repository.SpaceShipRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Data
@Service
@RequiredArgsConstructor
public class SpaceShipService {
    private final SpaceShipRepository spaceShipRepository;
    private final PlanetService planetService;
    @Transactional
    public List<SpaceShip> findAllShips(){
        return spaceShipRepository.findAll();
    }

    public SpaceShip createSpaceShip(SpaceShip spaceShip){
        return spaceShipRepository.save(spaceShip);
    }

    public SpaceShip getSpaceShipById(Long id){
        return spaceShipRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Нема корабля с индификатором "+id));
    }

    public void deleteSpaceShipById(Long id){
        spaceShipRepository.deleteById(id);
    }

    public SpaceShip updateSpaceShip(Long id, SpaceShip updateSpaceShip){
        SpaceShip exsistingSpaceShip = getSpaceShipById(id);
        exsistingSpaceShip.setShipCapaticy(updateSpaceShip.getShipCapaticy());
        exsistingSpaceShip.setShipName(updateSpaceShip.getShipName());
        exsistingSpaceShip.setShipCapaticy(updateSpaceShip.getShipCapaticy());
        exsistingSpaceShip.setCurrentShipFuel(updateSpaceShip.getCurrentShipFuel());
        exsistingSpaceShip.setCurrentPlanet(updateSpaceShip.getCurrentPlanet());
        return spaceShipRepository.save(exsistingSpaceShip);
    }
    public SpaceShip moveSpaceShip(Long shipId, Long planetId){
        SpaceShip exsistingSpaceShip = getSpaceShipById(shipId);
        Planet targetPlanet = planetService.getPlanetById(planetId);
        if (exsistingSpaceShip.getCurrentShipFuel()<10) throw new LowFuelExeption("Не хватает топлива");
        exsistingSpaceShip.setCurrentShipFuel(exsistingSpaceShip.getCurrentShipFuel()-10);
        exsistingSpaceShip.setCurrentPlanet(targetPlanet);
        return spaceShipRepository.save(exsistingSpaceShip);
    }

}


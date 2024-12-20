package com.example.PlanetShipsProject.service;
import com.example.PlanetShipsProject.Mapper.PlanetMapper;
import com.example.PlanetShipsProject.Mapper.PlanetResourceMapper;
import com.example.PlanetShipsProject.Mapper.SpaceShipMapper;
import com.example.PlanetShipsProject.dto.PlanetDTO;
import com.example.PlanetShipsProject.dto.SpaceShipDTO;
import com.example.PlanetShipsProject.model.Planet;
import com.example.PlanetShipsProject.repository.PlanetRepository;
import com.example.PlanetShipsProject.repository.PlanetResourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@RequiredArgsConstructor
@Service
public class PlanetService {
    private final PlanetRepository planetRepository;
    private final PlanetMapper planetMapper;
    private final SpaceShipMapper spaceShipMapper;
    private final PlanetResourseRepository planetResourseRepository;
    private final PlanetResourceMapper planetResourceMapper;

    public List<PlanetDTO> findAllPlanets(){
        return planetRepository.findAll().stream().map(planetMapper::planetEntityToDTO).toList();
    }

    @Transactional
    public void createPlanet(PlanetDTO planetDTO){
        Planet planet = new Planet();
        planet.setPlanetResource(planetResourceMapper.planetresourceDTOToEntity(planetDTO.getPlanetResource()));
        planet.setId(planetDTO.getId());
        planet.setName(planetDTO.getName());
        planet.setFuelPrice(planetDTO.getFuelPrice());
        planet.setListOfShips(planetDTO.getListOfShips().stream().map(spaceShipMapper::spaceShipDTOToEntity).toList());
       planetRepository.save(planet);
    }

    public PlanetDTO getPlanetById(Long id){
        Planet planet = planetRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Нема планеты с индификатором "+id));
        return planetMapper.planetEntityToDTO(planet);
    }

    @Transactional
    public void deletePlanet (Long id){
        planetRepository.deleteById(id);
    }

    @Transactional
    public void updatePlanet(Long id, PlanetDTO updatePlanetDTO){
        Planet exsistingPlanet = planetMapper.planetDTOtoEntity(getPlanetById(id));
        exsistingPlanet.setName(updatePlanetDTO.getName());
        exsistingPlanet.setPlanetResource(planetResourseRepository.getReferenceById(updatePlanetDTO.getPlanetResource().getId()));
        exsistingPlanet.setFuelPrice(updatePlanetDTO.getFuelPrice());
        planetRepository.save(exsistingPlanet);
    }

    @Transactional
    public void updatePlanetFuelPrice(Long planetDTOId, Double newFuelPrice){
        Planet exsistingPlanet = planetMapper.planetDTOtoEntity(getPlanetById(planetDTOId));
        exsistingPlanet.setFuelPrice(newFuelPrice);
        planetMapper.planetEntityToDTO(planetRepository.save(exsistingPlanet));
    }

    public List<SpaceShipDTO> getAllSpaceShipsOnAPlanet(Long planetDTOId){
        Planet exsistingPlanet = planetMapper.planetDTOtoEntity(getPlanetById(planetDTOId));
        return exsistingPlanet.getListOfShips().stream().map(spaceShipMapper::spaceShipEntityToDTO).toList();
    }
}
package com.example.PlanetShipsProject.service;
import com.example.PlanetShipsProject.Mapper.PlanetMapper;
import com.example.PlanetShipsProject.Mapper.SpaceShipMapper;
import com.example.PlanetShipsProject.dto.PlanetDTO;
import com.example.PlanetShipsProject.dto.SpaceShipDTO;
import com.example.PlanetShipsProject.model.Planet;
import com.example.PlanetShipsProject.repository.PlanetRepository;
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

    public List<PlanetDTO> findAllPlanets(){
        return planetMapper.planetListEntityToDTO(planetRepository.findAll());
    }

    @Transactional
    public void createPlanet(PlanetDTO planetDTO){
       planetRepository.save(planetMapper.planetDtoToEntity(planetDTO));
    }

    public PlanetDTO getPlanetById(Long id){
        Planet planet = planetRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Нема планеты с индификатором "+id));
        return planetMapper.planetEntityToDto(planet);
    }

    @Transactional
    public void deletePlanet (Long id){
        planetRepository.deleteById(id);
    }

    @Transactional
    public void updatePlanet(Long id, PlanetDTO updatePlanetDTO){
        Planet exsistingPlanet = planetMapper.planetDtoToEntity(getPlanetById(id));
        exsistingPlanet.setName(updatePlanetDTO.getName());
        exsistingPlanet.setPlanetResource(updatePlanetDTO.getPlanetResource());
        exsistingPlanet.setFuelPrice(updatePlanetDTO.getFuelPrice());
        planetRepository.save(exsistingPlanet);
    }

    @Transactional
    public PlanetDTO updatePlanetFuelPrice(Long planetDTOId, Double newFuelPrice){
        Planet exsistingPlanet = planetMapper.planetDtoToEntity(getPlanetById(planetDTOId));
        exsistingPlanet.setFuelPrice(newFuelPrice);
        return planetMapper.planetEntityToDto(planetRepository.save(exsistingPlanet));
    }

    public List<SpaceShipDTO> getAllSpaceShipsOnAPlanet(Long planetDTOId){
        Planet exsistingPlanet = planetMapper.planetDtoToEntity(getPlanetById(planetDTOId));
        return spaceShipMapper.spaceShipListEntityToDTO(exsistingPlanet.getListOfShips());
    }
}
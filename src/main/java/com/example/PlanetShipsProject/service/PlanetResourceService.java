package com.example.PlanetShipsProject.service;

import com.example.PlanetShipsProject.Mapper.PlanetMapping;
import com.example.PlanetShipsProject.Mapper.PlanetResourceMapping;
import com.example.PlanetShipsProject.Mapper.SpaceShipMapping;
import com.example.PlanetShipsProject.dto.PlanetDTO;
import com.example.PlanetShipsProject.dto.PlanetResourceDTO;
import com.example.PlanetShipsProject.dto.SpaceShipDTO;
import com.example.PlanetShipsProject.model.PlanetResource;
import com.example.PlanetShipsProject.repository.PlanetResourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
public class PlanetResourceService{
  private final  PlanetResourseRepository planetResourseRepository;
  private final PlanetResourceMapping planetResourceMapping;
  private final SpaceShipMapping spaceShipMapping;
  private final PlanetMapping planetMapping;

    public List<PlanetResourceDTO> findAllPlanetResources(){
        List<PlanetResource> planetResourceList = planetResourseRepository.findAll();
        return planetResourceList.stream().map(planetResourceMapping::planetResourceEntityToDto).collect(Collectors.toList());
    }
    @Transactional
    public void createPlanetResource(PlanetResourceDTO planetResourceDTO){
        planetResourseRepository.save(planetResourceMapping.planetResourceDtoToEntity(planetResourceDTO));
    }

    @Transactional
    public PlanetResourceDTO getPlanetResourceById(Long id){
        PlanetResource planetResource = planetResourseRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Нема реса с индификатором "+id));
        return planetResourceMapping.planetResourceEntityToDto(planetResource);
    }
    @Transactional
    public void deletePlanetResource (Long id){
        planetResourseRepository.deleteById(id);
    }

    @Transactional
    public void updatePlanetResource(Long id, PlanetResourceDTO planetResourceDTO){
        PlanetResource planetResource = planetResourceMapping.planetResourceDtoToEntity(getPlanetResourceById(id));
        planetResource.setName(planetResourceDTO.getName());
        planetResource.setRarity(planetResourceDTO.getRarity());
        planetResource.setListOfPlanets(planetResourceDTO.getListOfPlanets());
        planetResource.setListOfShips(planetResourceDTO.getListOfShips());
        planetResourseRepository.save(planetResource);
    }

    public List<SpaceShipDTO> findAllSpaceShipsCarringThisResource(Long planetResourceId){
        PlanetResource planetResource = planetResourceMapping.planetResourceDtoToEntity(getPlanetResourceById(planetResourceId));
        return spaceShipMapping.spaceShipListEntityToDTO(planetResource.getListOfShips());
    }

    public List<PlanetDTO> findAllPlanetsWithThisResource(Long planetResourceId){
        PlanetResource planetResource = planetResourceMapping.planetResourceDtoToEntity(getPlanetResourceById(planetResourceId));
        return planetMapping.planetListEntityToDTO(planetResource.getListOfPlanets());
    }
}


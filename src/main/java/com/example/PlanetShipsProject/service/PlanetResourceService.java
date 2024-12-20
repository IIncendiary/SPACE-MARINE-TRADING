package com.example.PlanetShipsProject.service;

import com.example.PlanetShipsProject.Mapper.PlanetMapper;
import com.example.PlanetShipsProject.Mapper.PlanetResourceMapper;
import com.example.PlanetShipsProject.Mapper.SpaceShipMapper;
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

@Service
@Data
@RequiredArgsConstructor
public class PlanetResourceService{
  private final  PlanetResourseRepository planetResourseRepository;
  private final PlanetResourceMapper planetResourceMapper;
  private final SpaceShipMapper spaceShipMapper;
  private final PlanetMapper planetMapper;

    public List<PlanetResourceDTO> findAllPlanetResources(){
        return planetResourseRepository.findAll().stream().map(planetResourceMapper::planetresourceEntityToDTO).toList();
    }

    @Transactional
    public void createPlanetResource(PlanetResourceDTO planetResourceDTO){
        planetResourseRepository.save(planetResourceMapper.planetresourceDTOToEntity(planetResourceDTO));
    }

    @Transactional
    public PlanetResourceDTO getPlanetResourceById(Long id){
        PlanetResource planetResource = planetResourseRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Нема реса с индификатором "+id));
        return planetResourceMapper.planetresourceEntityToDTO(planetResource);
    }

    @Transactional
    public void deletePlanetResource (Long id){
        planetResourseRepository.deleteById(id);
    }

    @Transactional
    public void updatePlanetResource(Long id, PlanetResourceDTO planetResourceDTO){
        PlanetResource planetResource = planetResourceMapper.planetresourceDTOToEntity(getPlanetResourceById(id));
        planetResource.setName(planetResourceDTO.getName());
        planetResource.setRarity(planetResourceDTO.getRarity());
        planetResource.setListOfPlanets(planetResourceDTO.getListOfPlanets().stream().map(planetMapper::planetDTOtoEntity).toList());
        planetResource.setListOfShips(planetResourceDTO.getListOfShips().stream().map(spaceShipMapper::spaceShipDTOToEntity).toList());
        planetResourseRepository.save(planetResource);
    }

    public List<SpaceShipDTO> findAllSpaceShipsCarringThisResource(Long planetResourceId){
         PlanetResource planetResource = planetResourceMapper.planetresourceDTOToEntity(getPlanetResourceById(planetResourceId));
        // return spaceShipMapper.spaceShipListEntityToDTO(planetResource.getListOfShips());
        return planetResource.getListOfShips().stream().map(spaceShipMapper::spaceShipEntityToDTO).toList();
    }

    public List<PlanetDTO> findAllPlanetsWithThisResource(Long planetResourceId){
        PlanetResource planetResource = planetResourceMapper.planetresourceDTOToEntity(getPlanetResourceById(planetResourceId));
        return  planetResource.getListOfPlanets().stream().map(planetMapper::planetEntityToDTO).toList();
    }
}


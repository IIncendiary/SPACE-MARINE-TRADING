package com.example.PlanetShipsProject.service;

import com.example.PlanetShipsProject.model.Planet;
import com.example.PlanetShipsProject.model.PlanetResource;
import com.example.PlanetShipsProject.repository.PlanetResourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class PlanetResourceService{
  private final  PlanetResourseRepository planetResourseRepository;
    @Transactional
    public List<PlanetResource> findAllPlanets(){
        return planetResourseRepository.findAll();
    }
    @Transactional
    public PlanetResource createPlanetRecource(PlanetResource planetResource){
        return planetResourseRepository.save(planetResource);
    }
    @Transactional
    public PlanetResource getPlanetByIdRecource(Long id){
        return planetResourseRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Нема реса с индификатором "+id));
    }
    @Transactional
    public void deletePlanetRecource (Long id){
        planetResourseRepository.deleteById(id);
    }
}

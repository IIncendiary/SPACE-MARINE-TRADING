package com.example.PlanetShipsProject.Mapper;

import com.example.PlanetShipsProject.dto.PlanetDTO;
import com.example.PlanetShipsProject.model.Planet;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface PlanetMapper   {
    Planet planetDTOtoEntity(PlanetDTO planetDTO);
    PlanetDTO planetEntityToDTO(Planet planet);
}

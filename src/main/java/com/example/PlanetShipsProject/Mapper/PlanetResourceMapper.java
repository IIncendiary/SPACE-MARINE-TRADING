package com.example.PlanetShipsProject.Mapper;

import com.example.PlanetShipsProject.dto.PlanetResourceDTO;
import com.example.PlanetShipsProject.model.PlanetResource;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface PlanetResourceMapper {
    PlanetResource planetresourceDTOToEntity(PlanetResourceDTO planetResourceDTO);
    PlanetResourceDTO planetresourceEntityToDTO(PlanetResource planetResource);
}

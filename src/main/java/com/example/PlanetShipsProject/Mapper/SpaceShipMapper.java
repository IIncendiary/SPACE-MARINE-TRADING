package com.example.PlanetShipsProject.Mapper;

import com.example.PlanetShipsProject.dto.SpaceShipDTO;
import com.example.PlanetShipsProject.model.SpaceShip;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface SpaceShipMapper {
    SpaceShip spaceShipDTOToEntity(SpaceShipDTO spaceShipDTO);
    SpaceShipDTO spaceShipEntityToDTO(SpaceShip spaceShip);
}

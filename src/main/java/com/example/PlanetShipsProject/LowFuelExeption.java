package com.example.PlanetShipsProject;

public class LowFuelExeption extends RuntimeException{
    public LowFuelExeption(String message){
        super(message);
    }
}

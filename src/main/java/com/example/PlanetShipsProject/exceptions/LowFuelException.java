package com.example.PlanetShipsProject.exceptions;

public class LowFuelException extends RuntimeException{
    public LowFuelException(String message){
        super(message);
    }
}

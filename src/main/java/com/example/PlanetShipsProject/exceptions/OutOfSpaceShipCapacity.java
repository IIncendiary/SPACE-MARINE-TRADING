package com.example.PlanetShipsProject.exceptions;

public class OutOfSpaceShipCapacity extends RuntimeException{
    public OutOfSpaceShipCapacity(String message){
        super(message);
    }
}

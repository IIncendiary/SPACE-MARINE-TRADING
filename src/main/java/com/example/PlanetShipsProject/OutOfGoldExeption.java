package com.example.PlanetShipsProject;

public class OutOfGoldExeption extends RuntimeException{
    public OutOfGoldExeption(String message){
        super(message);
    }
}

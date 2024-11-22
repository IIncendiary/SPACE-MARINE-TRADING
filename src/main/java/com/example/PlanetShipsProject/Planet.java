package com.example.PlanetShipsProject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String resource;
    private Double distanceFromEarth;
    private Double quanitytyOfResource;

    public Long getId() {
        return id;
    }

    public Double getQuanitytyOfResource() {
        return quanitytyOfResource;
    }

    public void setQuanitytyOfResource(Double quanitytyOfResource) {
        this.quanitytyOfResource = quanitytyOfResource;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Double getDistanceFromEarth() {
        return distanceFromEarth;
    }

    public void setDistanceFromEarth(Double distanceFromEarth) {
        this.distanceFromEarth = distanceFromEarth;
    }
}

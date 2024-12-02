package com.example.PlanetShipsProject.controller;

import com.example.PlanetShipsProject.model.Planet;
import com.example.PlanetShipsProject.service.PlanetService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/planets")
public class PlanetController {
    final PlanetService planetService;
}

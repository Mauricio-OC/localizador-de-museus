package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Museum controller.
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {
  private final MuseumServiceInterface service;

  @Autowired
  public MuseumController(MuseumServiceInterface service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Museum> createMuseum(@RequestBody Museum museumCreationDto) {
    Museum createdMuseum = service.createMuseum(museumCreationDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdMuseum);
  }

  /**
   * Rota get.
   */
  @GetMapping("/closest")
  public ResponseEntity<Museum> getClosestMuseum(
      @RequestParam("lat") double lat,
      @RequestParam("lng") double lng,
      @RequestParam("max_dist_km") Double maxDistanceKm
  ) {
    Coordinate coordinate = new Coordinate(lat, lng);
    Museum closestMuseum = service.getClosestMuseum(coordinate, maxDistanceKm);

    if (closestMuseum != null) {
      return ResponseEntity.ok(closestMuseum);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}

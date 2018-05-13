package com.example.geocacheapi.controllers;


import com.example.geocacheapi.models.Geocache;
import com.example.geocacheapi.models.LocationRequest;
import com.example.geocacheapi.repositories.GeocacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GeocacheController {
    @Autowired

    private GeocacheRepository geocacheRepository;
    private Long aircraftId;
    private Geocache geocacheRequest;
    private LocationRequest locationRequest;

    @GetMapping("/")
    public Iterable<Geocache> findAllAircraft() {
        return geocacheRepository.findAll();
    }

    @GetMapping("/{aircraftId}")
    public Geocache findAircraftById(@PathVariable Long aircraftId) {
        return geocacheRepository.findOne(aircraftId);
    }


    @PostMapping("/searchradius")
    public Iterable<Geocache> findAircraftById(@RequestBody LocationRequest locationRequest) {
        return geocacheRepository.findByLocation(locationRequest.getLatitude(), locationRequest.getLongitude(), locationRequest.getRadius());
    }

}

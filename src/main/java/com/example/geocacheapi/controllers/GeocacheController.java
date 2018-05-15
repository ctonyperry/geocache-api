package com.example.geocacheapi.controllers;


import com.example.geocacheapi.models.GeocacheResponse;
import com.example.geocacheapi.models.Geocache;
import com.example.geocacheapi.models.LocationRequest;
import com.example.geocacheapi.repositories.GeocacheRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class GeocacheController {
    @Autowired

    private GeocacheRepository geocacheRepository;
    private Long geocacheId;
    private Geocache geocacheRequest;
    private LocationRequest locationRequest;
    private GeocacheResponse geocacheResponse;

    @GetMapping("/")
    public Iterable<Geocache> findAllAircraft() {
        return geocacheRepository.findAll();
    }

    @GetMapping("/{geocacheId}")
    public Geocache findAircraftById(@PathVariable Long geocacheId) {
        return geocacheRepository.findOne(geocacheId);
    }

    @PostMapping("/caches/getByRadius")
    public Iterable<Geocache> findGeocacheByRadius(@RequestBody LocationRequest locationRequest) {
        double radius = locationRequest.getRadius() * 0.01818181818;

        Iterable<Geocache> geoCaches = geocacheRepository.findByLocation(locationRequest.getLatitude(), locationRequest.getLongitude(), radius);
        return geoCaches;
    }

    @PostMapping("/caches/getByBoundingBox")
    public Iterable<Geocache> findGeoCachesInBoundingBox(@RequestBody LocationRequest locationRequest) {
        double radius = locationRequest.getRadius() * 0.01818181818;
        Iterable<Geocache> geoCaches = geocacheRepository.findByBoundingBox(locationRequest.getMinLatitude(),
                locationRequest.getMaxLatitude(),
                locationRequest.getMinLongitude(),
                locationRequest.getMaxLongitude());


        return geoCaches;
    }

    @GetMapping("/caches/deleteCache/{geocacheId}")
    public void deleteCache(@PathVariable Long geocacheId){
        geocacheRepository.delete(geocacheId);
    }

}

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
    private Long aircraftId;
    private Geocache geocacheRequest;
    private LocationRequest locationRequest;
    private GeocacheResponse geocacheResponse;



    @GetMapping("/")
    public Iterable<Geocache> findAllAircraft() {
        return geocacheRepository.findAll();
    }

    @GetMapping("/{aircraftId}")
    public Geocache findAircraftById(@PathVariable Long aircraftId) {
        return geocacheRepository.findOne(aircraftId);
    }


//    @PostMapping("/searchradius")
//    public Iterable<Geocache> findGeocacheByLocatiobn(@RequestBody LocationRequest locationRequest) {
//        double radius = locationRequest.getRadius() * 0.01818181818;
//        return geocacheRepository.findByLocation(locationRequest.getLatitude(), locationRequest.getLongitude(), radius);
//    }

    @PostMapping("/getcaches")
    public GeocacheResponse findGeocacheByLocatiobnWithMetaData(@RequestBody LocationRequest locationRequest) {
        double radius = locationRequest.getRadius() * 0.01818181818;

        geocacheResponse = new GeocacheResponse();
        Iterable<Geocache> geoCaches = geocacheRepository.findByLocation(locationRequest.getLatitude(), locationRequest.getLongitude(), radius);
        geocacheResponse.setGeocaches(geoCaches);

        geocacheResponse.setMessage("Success");

        //This is a reaaaally stupid way to do this, fix it later.
        geocacheResponse.setNumRecords(Lists.newArrayList(geoCaches).size());

        return geocacheResponse;
    }






}

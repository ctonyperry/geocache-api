package com.example.geocacheapi.repositories;

import com.example.geocacheapi.models.Geocache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface GeocacheRepository extends CrudRepository<Geocache, Long> {


    public Iterable<Geocache> findByLocation(@Param("latitude") double latitude, @Param("longitude") double longitude, @Param("radius") double range);
}
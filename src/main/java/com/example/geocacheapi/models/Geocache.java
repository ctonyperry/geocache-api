package com.example.geocacheapi.models;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity

@Table(name = "geocaches")
@NamedQuery(name = "Geocache.findByLocation",
        query = "select id, label, latitude, longitude, description from Geocache " +
                "where " +
                "(lat > ?1-?3 and lat < ?1+?3) AND " +
                "(long > ?2 - ?3 and long < ?2+?3)")

public class Geocache {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "label")
    private String label;

    @Column(name = "LAT")
    private double latitude;

    @Column(name = "LONG")
    private double longitude;

    @Column(name="DESCRIPTION")
    private String description;

}

//    String aircraftRadiusQuery ="select * from aircraft where (lat > ?1-5 and lat < ?1+5) AND (long > 35 - 5 and long < 35+5)";"
//CREATE TABLE GEOCACHES (
//        ID serial,
//        LABEL varchar(100) NOT NULL,
//    LAT real NOT NULL,
//    LONG real NOT NULL,
//    DESCRIPTION text NOT NULL
//)
package com.example.geocacheapi.models;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity

@Table(name = "aircraft")
@NamedQuery(name = "Geocache.findByLocation",
        query = "select id, label, tailNumber, latitude, longitude, heading, airspeed from Geocache " +
                "where " +
                "(lat > ?1-?3 and lat < ?1+?3) AND " +
                "(long > ?2 - ?3 and long < ?2+?3)")

public class Geocache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "label")
    private String label;

    @Column(name = "tail_number")
    private String tailNumber;

    @Column(name = "lat")
    private double latitude;

    @Column(name = "long")
    private double longitude;

    @Column(name = "heading")
    private double heading;

    @Column(name = "airspeed")
    private double airspeed;

}

//    String aircraftRadiusQuery ="select * from aircraft where (lat > ?1-5 and lat < ?1+5) AND (long > 35 - 5 and long < 35+5)";"

package com.example.geocacheapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;


@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity

@Table(name = "geocaches")
@NamedQueries({
@NamedQuery(name = "Geocache.findByLocation",
        query = "select id, label, latitude, longitude, description from Geocache " +
                "where " +
                "(lat > ?1-?3 and lat < ?1+?3) AND " +
                "(long > ?2 - ?3 and long < ?2+?3)"),

@NamedQuery(name = "Geocache.findByBoundingBox",
        query = "select id, label, latitude, longitude, description from Geocache " +
                "where " +
                "(lat > ?1 and lat < ?2 ) AND " +
                "(long >  ?3  and long < ?4)")
})

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

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    @JsonProperty("latitude")
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    @JsonProperty("longitude")
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
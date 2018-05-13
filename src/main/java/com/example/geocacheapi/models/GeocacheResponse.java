package com.example.geocacheapi.models;

public class GeocacheResponse {
    private int numRecords;
    private String message;
    
    private Iterable<Geocache> geocaches;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }




    public Iterable<Geocache> getGeocaches() {
        return geocaches;
    }

    public void setGeocaches(Iterable<Geocache> geocaches) {
        this.geocaches = geocaches;
    }

    public int getNumRecords() {
        return numRecords;
    }

    public void setNumRecords(int numRecords) {
        this.numRecords = numRecords;
    }
}

package com.driver.model;

import javax.persistence.*;

@Entity
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int farePerKm;
    private boolean available;
    public Cab() {
    }

    public Cab(int id, int farePerKm, boolean available) {
        this.id = id;
        this.farePerKm = farePerKm;
        this.available = available;
    }

    public Cab(int farePerKm, boolean available) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFarePerKm() {
        return farePerKm;
    }

    public void setFarePerKm(int farePerKm) {
        this.farePerKm = farePerKm;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}

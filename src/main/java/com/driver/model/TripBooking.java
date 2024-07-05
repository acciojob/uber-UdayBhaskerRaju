package com.driver.model;

import javax.persistence.*;

@Entity
public class TripBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tripBookingId;
    private String fromLocation;
    private String toLocation;
    private int distanceInKm;

    @Enumerated(EnumType.STRING)
    private TripStatus status;
    private int farePrice;

    @ManyToOne
    @JoinColumn
    Cab cab;

    public TripBooking() {
    }

    public TripBooking(int id, String tripBookingId, String fromLocation, String toLocation, int distanceInKm, TripStatus status, int farePrice, Cab cab) {
        this.id = id;
        this.tripBookingId = tripBookingId;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.distanceInKm = distanceInKm;
        this.status = status;
        this.farePrice = farePrice;
        this.cab = cab;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(int distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public int getFarePrice() {
        return farePrice;
    }

    public void setFarePrice(int farePrice) {
        this.farePrice = farePrice;
    }

    public String getTripBookingId() {
        return tripBookingId;
    }

    public void setTripBookingId(String tripBookingId) {
        this.tripBookingId = tripBookingId;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }
}

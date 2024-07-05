package com.driver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Column(unique = true,nullable = false)
    private String emailId;
    private String gender;

    @OneToMany
    @JoinColumn
    List<TripBooking> tripBookings = new ArrayList<>();

    public Customer() {
    }

    public Customer(Integer id, String name,List<TripBooking> tripBookings,String emailId,String gender) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.gender= gender;
        this.tripBookings = tripBookings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TripBooking> getTripBookings() {
        return tripBookings;
    }

    public void setTripBookings(List<TripBooking> tripBookings) {
        this.tripBookings = tripBookings;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

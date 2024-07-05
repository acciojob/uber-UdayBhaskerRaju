package com.driver.model;

import javax.persistence.*;

@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String mobile;
    private String password;
    @OneToOne
    @JoinColumn
    Cab cab;
    public Driver() {
    }

    public Driver(int id, String mobile, String password, Cab cab) {
        this.id = id;
        this.mobile = mobile;
        this.password = password;
        this.cab = cab;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }
}

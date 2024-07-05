package com.driver.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false)
    private String password;
    public Admin() {
    }
    public Admin(int id, String password) {
        this.id = id;
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

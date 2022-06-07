package com.example.BankSystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "address",uniqueConstraints = { @UniqueConstraint(columnNames = { "houseNumber", "streetAddress",
        "city", "state","zipCode" }) })
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "address_id",nullable = false)
    private Long id;

    @Column(name = "houseNumber",length = 50, nullable = false)
    private String houseNumber;

    @Column(name = "streetAddress",length = 50, nullable = false)
    private String streetAddress;

    @Column(name = "city",length = 50, nullable = false)
    private String city;

    @Column(name = "state",length = 50, nullable = false)
    private String state;

    @Column(name = "zipCode",length = 50, nullable = false)
    private String zipCode;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

}

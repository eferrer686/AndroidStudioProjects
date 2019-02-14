package com.example.edfmg.recyclingplaces.model;

import java.io.Serializable;

public class PlaceCard implements Serializable{

    private String id;
    private String schedule;
    private String website;
    private String name;
    private String street;
    private String streetNumber;
    private String phoneNumber;
    private String city;

    public PlaceCard(){
    }

    public PlaceCard(String id, String schedule, String website, String name, String street, String streetNumber, String phoneNumber, String city) {
        this.id = id;
        this.schedule = schedule;
        this.website = website;
        this.name = name;
        this.street = street;
        this.streetNumber = streetNumber;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }




}

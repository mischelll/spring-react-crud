package com.example.crud.service.dto;

import javax.validation.constraints.NotNull;


public class GroupDTO {

    @NotNull
    private String name;
    private String address;
    private String city;
    private String stateOfProvince;
    private String country;
    private String postalCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateOfProvince() {
        return stateOfProvince;
    }

    public void setStateOfProvince(String stateOfProvince) {
        this.stateOfProvince = stateOfProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}

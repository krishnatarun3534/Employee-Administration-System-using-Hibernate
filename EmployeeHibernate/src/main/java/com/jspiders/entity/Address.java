package com.jspiders.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String state;
    private String country;
    private Integer countryCode;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", countryCode=" + countryCode +
                '}';
    }
}

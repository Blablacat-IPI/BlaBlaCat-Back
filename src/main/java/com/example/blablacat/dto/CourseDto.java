package com.example.blablacat.dto;

import java.time.LocalDateTime;

public class CourseDto {

    private Integer idDriver;
    private LocalDateTime date;

    private String cityDeparture;
    private Integer departureZipCode;
    private String streetDeparture;

    private String cityArrival;
    private Integer arrivalZipCode;
    private String streetArrival;

    private Integer numberPlace;

    public Integer getDepartureZipCode() {
        return departureZipCode;
    }

    public void setDepartureZipCode(Integer departureZipCode) {
        this.departureZipCode = departureZipCode;
    }

    public Integer getArrivalZipCode() {
        return arrivalZipCode;
    }

    public void setArrivalZipCode(Integer arrivalZipCode) {
        this.arrivalZipCode = arrivalZipCode;
    }

    public Integer getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Integer idDriver) {
        this.idDriver = idDriver;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getCityDeparture() {
        return cityDeparture;
    }

    public void setCityDeparture(String cityDeparture) {
        this.cityDeparture = cityDeparture;
    }

    public String getStreetDeparture() {
        return streetDeparture;
    }

    public void setStreetDeparture(String streetDeparture) {
        this.streetDeparture = streetDeparture;
    }

    public String getCityArrival() {
        return cityArrival;
    }

    public void setCityArrival(String cityArrival) {
        this.cityArrival = cityArrival;
    }

    public String getStreetArrival() {
        return streetArrival;
    }

    public void setStreetArrival(String streetArrival) {
        this.streetArrival = streetArrival;
    }

    public Integer getNumberPlace() {
        return numberPlace;
    }

    public void setNumberPlace(Integer numberPlace) {
        this.numberPlace = numberPlace;
    }
}

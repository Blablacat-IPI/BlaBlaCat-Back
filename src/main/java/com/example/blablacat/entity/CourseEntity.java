package com.example.blablacat.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Course")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_driver")
    private Integer idDriver;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "city_departure")
    private String cityDeparture;

    @Column(name= "departure_zip_code")
    private Integer departureZipCode;

    @Column(name = "street_departure")
    private String streetDeparture;

    @Column(name = "city_arrival")
    private String cityArrival;

    @Column(name= "arrival_zip_code")
    private Integer arrivalZipCode;

    @Column(name = "street_arrival")
    private String streetArrival;

    @Column(name = "number_place")
    private Integer numberPlace;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}

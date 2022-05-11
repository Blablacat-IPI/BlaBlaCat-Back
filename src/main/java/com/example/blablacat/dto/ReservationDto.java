package com.example.blablacat.dto;

import java.time.LocalDateTime;

public class ReservationDto {
    private Integer user_id;
    private Integer course_id;
    private String displayName;
    private String displayDepartureAddress;
    private String displayArrivalAddress;
    private LocalDateTime displayDate;

    private String username;

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public LocalDateTime getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(LocalDateTime displayDate) {
        this.displayDate = displayDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayDepartureAddress() {
        return displayDepartureAddress;
    }

    public void setDisplayDepartureAddress(String displayDepartureAddress) {
        this.displayDepartureAddress = displayDepartureAddress;
    }

    public String getDisplayArrivalAddress() {
        return displayArrivalAddress;
    }

    public void setDisplayArrivalAddress(String displayArrivalAddress) {
        this.displayArrivalAddress = displayArrivalAddress;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }
}

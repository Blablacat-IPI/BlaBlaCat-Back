package com.example.blablacat.services;

import com.example.blablacat.dto.CourseDto;
import com.example.blablacat.entity.CourseEntity;
import com.example.blablacat.entity.UserEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ICourseService {

    CourseDto toDto(CourseEntity entity);

    List<CourseDto> getAllCourse();

    Integer addCourse(LocalDateTime date, String cityDeparture, Integer departureZipCode, String streetDeparture, String cityArrival, Integer arrivalZipCode, String streetArrival, Integer numberPlace);

    List<CourseDto> getAllCity(String city);

}


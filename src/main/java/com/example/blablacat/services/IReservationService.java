package com.example.blablacat.services;

import com.example.blablacat.dto.CourseDto;
import com.example.blablacat.dto.ReservationDto;
import com.example.blablacat.entity.ReservationEntity;

import java.util.List;

public interface IReservationService {

    ReservationDto toDto(ReservationEntity reservationEntity);
    ReservationDto get (Integer id);

    Integer addReservation(CourseDto courseDto);

    List<ReservationDto> getAllCourses();

    Boolean exists(Integer id);
}

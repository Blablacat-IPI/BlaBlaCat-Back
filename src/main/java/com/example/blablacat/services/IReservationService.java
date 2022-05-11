package com.example.blablacat.services;

import com.example.blablacat.dto.ReservationDto;
import com.example.blablacat.entity.ReservationEntity;

import java.util.List;

public interface IReservationService {

    ReservationDto toDto(ReservationEntity reservationEntity);
    ReservationDto get (Integer id);

    Integer save(ReservationDto dto);

    List<ReservationDto> getAllCourses();

    List<ReservationDto> getAllCoursesPage(Integer page, Integer size);

    Boolean exists(Integer id);
}

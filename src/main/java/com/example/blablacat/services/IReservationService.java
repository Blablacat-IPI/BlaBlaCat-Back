package com.example.blablacat.services;

import com.example.blablacat.dto.ReservationDto;
import com.example.blablacat.entity.ReservationEntity;

public interface IReservationService {

    ReservationDto toDto(ReservationEntity reservationEntity);
    ReservationDto get (Integer id);

    Integer save(ReservationDto dto);

    Boolean exists(Integer id);
}

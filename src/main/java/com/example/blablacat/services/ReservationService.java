package com.example.blablacat.services;

import com.example.blablacat.dto.CourseDto;
import com.example.blablacat.dto.ReservationDto;
import com.example.blablacat.entity.CourseEntity;
import com.example.blablacat.entity.UserEntity;
import com.example.blablacat.entity.ReservationEntity;
import com.example.blablacat.repository.CourseRepository;
import com.example.blablacat.repository.UserRepository;
import com.example.blablacat.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService implements IReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    CourseRepository courseRepository;

    @Override
    public ReservationDto toDto(ReservationEntity reservationEntity ) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setDisplayName(reservationEntity.getUserEntity().getFirstName() + " " + reservationEntity.getUserEntity().getLastName() );
        reservationDto.setDisplayArrivalAddress("Arrivée : " + reservationEntity.getCourseEntity().getStreetArrival() + " " + reservationEntity.getCourseEntity().getArrivalZipCode() + " " + reservationEntity.getCourseEntity().getCityArrival());
        reservationDto.setDisplayDepartureAddress("Départ : " + reservationEntity.getCourseEntity().getDepartureZipCode() + " " + reservationEntity.getCourseEntity().getStreetDeparture() + " " + reservationEntity.getCourseEntity().getCityDeparture());
        reservationDto.setUser_id(reservationEntity.getUserEntity().getId());
        reservationDto.setCourse_id(reservationEntity.getCourseEntity().getId());
        reservationDto.setDisplayDate(reservationEntity.getCourseEntity().getDate());

        return reservationDto;
    }

    @Override
    public ReservationDto get(Integer id) {
        return toDto(reservationRepository.findById(id).get());
    }


    @Override
    public  Integer addReservation(CourseDto courseDto) {
            ReservationEntity entity = new ReservationEntity();
            UserEntity userEntity = userRepository.findById(10).get();
            entity.setUserEntity(userEntity);
            CourseEntity courseEntity = courseRepository.findById(courseDto.getId()).get();
            entity.setCourseEntity(courseEntity);
            entity.setCreatedAt(LocalDateTime.now());

            entity = reservationRepository.saveAndFlush(entity);
            return entity.getUser_has_course_id();
        }

    @Override
    public List<ReservationDto> getAllCourses() {
            List<ReservationEntity> list = reservationRepository.findAll();
            List<ReservationDto> listFinal = new ArrayList<>();

            for(int i = 0;i<list.size();i++){
                ReservationEntity entity = list.get(i);
                ReservationDto dto = this.toDto(entity);
                listFinal.add(dto);
            }
            return listFinal;
        }

    @Override
    public Boolean exists(Integer id) {
        return reservationRepository.existsById(id);
    }
}

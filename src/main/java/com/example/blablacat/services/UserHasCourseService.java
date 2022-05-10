package com.example.blablacat.services;

import com.example.blablacat.dto.AddUserToCourseDto;
import com.example.blablacat.entity.CourseEntity;
import com.example.blablacat.entity.UserEntity;
import com.example.blablacat.entity.UserHasCourseEntity;
import com.example.blablacat.repository.CourseRepository;
import com.example.blablacat.repository.RepositoryUser;
import com.example.blablacat.repository.UserHasCourseRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserHasCourseService implements IUserHasCourseService{
    @Autowired
    UserHasCourseRepository userHasCourseRepository;

    @Autowired
    RepositoryUser userRepository;
    @Autowired
    CourseRepository courseRepository;

    @Override
    public AddUserToCourseDto toDto(UserHasCourseEntity userHasCourseEntity ) {
        AddUserToCourseDto userHasCourseDto = new AddUserToCourseDto();
        userHasCourseDto.setDisplayName(userHasCourseEntity.getUserEntity().getFirstName() + " " + userHasCourseEntity.getUserEntity().getLastName() );
        userHasCourseDto.setDisplayArrivalAddress("Arrivée : " + userHasCourseEntity.getCourseEntity().getStreetArrival() + " " + userHasCourseEntity.getCourseEntity().getArrivalZipCode() + " " + userHasCourseEntity.getCourseEntity().getCityArrival());
        userHasCourseDto.setDisplayDepartureAddress("Départ : " + userHasCourseEntity.getCourseEntity().getDepartureZipCode() + " " + userHasCourseEntity.getCourseEntity().getStreetDeparture() + " " + userHasCourseEntity.getCourseEntity().getCityDeparture());
        userHasCourseDto.setUser_id(userHasCourseEntity.getUserEntity().getId());
        userHasCourseDto.setCourse_id(userHasCourseEntity.getCourseEntity().getId());
        userHasCourseDto.setDisplayDate(userHasCourseEntity.getCourseEntity().getDate());
        return userHasCourseDto;
    }

    @Override
    public AddUserToCourseDto get(Integer id) {
        return toDto(userHasCourseRepository.findById(id).get());
    }

    @Override
    public  Integer save(AddUserToCourseDto dto) {
            UserHasCourseEntity entity = new UserHasCourseEntity();
            UserEntity userEntity = userRepository.findById(dto.getUser_id()).get();
            entity.setUserEntity(userEntity);
            CourseEntity courseEntity = courseRepository.findById(dto.getCourse_id()).get();
            entity.setCourseEntity(courseEntity);
            entity.setCreatedAt(LocalDateTime.now());

            entity = userHasCourseRepository.saveAndFlush(entity);
            return entity.getUser_has_course_id();
        }

    @Override
    public Boolean exists(Integer id) {
        return userHasCourseRepository.existsById(id);
    }
}

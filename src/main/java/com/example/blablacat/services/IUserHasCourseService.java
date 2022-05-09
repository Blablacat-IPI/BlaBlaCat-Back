package com.example.blablacat.services;

import com.example.blablacat.dto.AddUserToCourseDto;
import com.example.blablacat.entity.CourseEntity;
import com.example.blablacat.entity.UserEntity;
import com.example.blablacat.entity.UserHasCourseEntity;

import java.util.List;

public interface IUserHasCourseService {

    AddUserToCourseDto toDto(UserHasCourseEntity userHasCourseEntity);
    AddUserToCourseDto get (Integer id);

    Integer save(AddUserToCourseDto dto);

    Boolean exists(Integer id);
}

package com.example.blablacat.services;

import com.example.blablacat.dto.CourseDto;
import com.example.blablacat.entity.CourseEntity;

import java.util.List;

public interface ICourseService {

    CourseDto toDto(CourseEntity entity);

    List<CourseDto> getAllCourse();
}

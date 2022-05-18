package com.example.blablacat.controller;

import com.example.blablacat.dto.CourseDto;
import com.example.blablacat.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("Course")
public class CourseController {

    @Autowired
    private ICourseService service;

    @GetMapping("all")
    public List<CourseDto> getAllCourse() { return service.getAllCourse();}

    @GetMapping("allValid")
    public List<CourseDto> getAllCoursesValid(){
        return service.getAllCoursesValid();
    }

    @GetMapping("lastFive")
    public List<CourseDto> getLastFiveCourses(){
        return service.getLastFiveCoursesCreated();
    }

    @GetMapping("searchcity/{city}")
    public List<CourseDto> getSearchCity(@PathVariable String city ) {
        return service.getAllCoursesByCity(city);
    }

    @PostMapping("add")
    public ResponseEntity<Integer> addCourses(@RequestBody CourseDto course_dto) {
        Integer course_id = service.addCourse(course_dto.getDate(), course_dto.getCityDeparture(), course_dto.getDepartureZipCode(), course_dto.getStreetDeparture(), course_dto.getCityArrival(), course_dto.getArrivalZipCode(),course_dto.getStreetArrival(), course_dto.getNumberPlace());
        try {
            return new ResponseEntity<>(course_id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Impossible d'ajouter un utilisateur à la course", HttpStatus.BAD_REQUEST);
        }
    }


}

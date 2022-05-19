package com.example.blablacat.controller;

import com.example.blablacat.dto.CourseDto;
import com.example.blablacat.dto.ReservationDto;
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
    private ICourseService courseService;

    @GetMapping("all")
    public List<CourseDto> getAllCourse() { return courseService.getAllCourse();}

    @GetMapping("allValid")
    public List<CourseDto> getAllCoursesValid(){
        return courseService.getAllCoursesValid();
    }

    @GetMapping("lastFive")
    public List<CourseDto> getLastFiveCourses(){
        return courseService.getLastFiveCoursesCreated();
    }

    @GetMapping("searchcity/{city}")
    public List<CourseDto> getSearchCity(@PathVariable String city ) {
        return courseService.getAllCoursesByCity(city);
    }

    @PostMapping("add")
    public ResponseEntity<Integer> addCourses(@RequestBody CourseDto course_dto) {
        Integer course_id = courseService.addCourse(course_dto.getDate(), course_dto.getCityDeparture(), course_dto.getDepartureZipCode(), course_dto.getStreetDeparture(), course_dto.getCityArrival(), course_dto.getArrivalZipCode(),course_dto.getStreetArrival(), course_dto.getNumberPlace());
        try {
            return new ResponseEntity<>(course_id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Impossible d'ajouter un utilisateur à la course", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("pageMaxMyCourses")
    public Integer pageMaxMyCourses() {
        //uniquement avec user 10 pour le moment, rajouter le @Request param user id et changer dans service d'angular plus tard
        return courseService.numberPageMaxCourseByUser();
    }

    @GetMapping("pageMyCourses")
    public List<CourseDto> PageMyCourses(@RequestParam Integer page){
        Integer size = 5;
        //uniquement avec user 10 pour le moment, rajouter le @Request param user id et changer dans service d'angular plus tard
        return courseService.getAllCoursesByUserPage(page, size);
    }


}

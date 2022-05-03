package com.example.blablacat.controller;

import com.example.blablacat.dto.CourseDto;
import com.example.blablacat.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Course")
public class CourseController {

    @Autowired
    private ICourseService service;

    @GetMapping("all")
    public List<CourseDto> getAllCourse() { return service.getAllCourse();}




}

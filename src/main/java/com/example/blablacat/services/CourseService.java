package com.example.blablacat.services;

import com.example.blablacat.dto.CourseDto;
import com.example.blablacat.entity.CourseEntity;
import com.example.blablacat.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository repository;

    @Override
    public CourseDto toDto(CourseEntity entity) {
        CourseDto cdto = new CourseDto();
        cdto.setIdDriver(entity.getIdDriver());
        cdto.setDate(entity.getDate());
        cdto.setCityDeparture(entity.getCityDeparture());
        cdto.setStreetDeparture(entity.getStreetDeparture());
        cdto.setCityArrival(entity.getCityArrival());
        cdto.setStreetArrival(entity.getStreetArrival());
        cdto.setNumberPlace(entity.getNumberPlace());

        return cdto;
    }

    @Override
    public List<CourseDto> getAllCourse() {
        List<CourseEntity> list = repository.findAll();
        List<CourseDto> listDto = new ArrayList<>();
        for (int i=0; i<list.size(); i++) {
            CourseEntity entity = list.get(i);
            CourseDto dto = this.toDto(entity);
            listDto.add(dto);
        }
        return listDto;
    }


}

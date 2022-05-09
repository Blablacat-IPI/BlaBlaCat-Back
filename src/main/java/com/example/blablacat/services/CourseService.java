package com.example.blablacat.services;

import com.example.blablacat.dto.CourseDto;
import com.example.blablacat.entity.CourseEntity;
import com.example.blablacat.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        cdto.setDepartureZipCode(entity.getDepartureZipCode());
        cdto.setStreetDeparture(entity.getStreetDeparture());
        cdto.setCityArrival(entity.getCityArrival());
        cdto.setArrivalZipCode(entity.getArrivalZipCode());
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

    @Override
    public List<CourseDto> getAllCity(String city) {
        List<CourseEntity> list = repository.findByCityDepartureOrCityArrival(city, city);
        List<CourseDto> listDto = new ArrayList<>();

        for(CourseEntity ce : list) {
            listDto.add(this.toDto(ce));
        }
        return listDto;
    }



    @Override
    public Integer addCourse(LocalDateTime date, String cityDeparture, Integer departureZipCode, String streetDeparture, String cityArrival, Integer arrivalZipCode, String streetArrival, Integer numberPlace) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setDate(date);
        courseEntity.setIdDriver(courseEntity.getIdDriver());
        courseEntity.setCityDeparture(cityDeparture);
        courseEntity.setDepartureZipCode(departureZipCode);
        courseEntity.setStreetDeparture(streetDeparture);
        courseEntity.setCityArrival(cityArrival);
        courseEntity.setArrivalZipCode(arrivalZipCode);
        courseEntity.setStreetArrival(streetArrival);
        courseEntity.setNumberPlace(numberPlace);
        courseEntity.setCreatedAt(LocalDateTime.now());

        repository.saveAndFlush(courseEntity);
        return courseEntity.getId();
    }


}

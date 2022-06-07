package com.example.blablacat.services;

import com.example.blablacat.dto.CourseDto;
import com.example.blablacat.dto.ReservationDto;
import com.example.blablacat.entity.CourseEntity;
import com.example.blablacat.entity.ReservationEntity;
import com.example.blablacat.entity.UserEntity;
import com.example.blablacat.repository.CourseRepository;
import com.example.blablacat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public CourseDto toDto(CourseEntity entity) {
        CourseDto cdto = new CourseDto();
        cdto.setId(entity.getId());
        cdto.setDriverUsername(entity.getUserEntity().getUsername());
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
        List<CourseEntity> list = courseRepository.findAll();
        List<CourseDto> listDto = new ArrayList<>();
        for (int i=0; i<list.size(); i++) {
            CourseEntity entity = list.get(i);
            CourseDto dto = this.toDto(entity);
            listDto.add(dto);
        }
        return listDto;
    }

    @Override
    public List<CourseDto> getAllCoursesValid() {
        List<CourseEntity> list = courseRepository.findAllByDeletedAtNullAndDateAfter(LocalDateTime.now());
        List<CourseDto> listDto = new ArrayList<>();

        for(CourseEntity entity : list){
            listDto.add(this.toDto(entity));
        }

        System.out.println(listDto);

        return listDto;
    }

    @Override
    public List<CourseDto> getLastFiveCoursesCreated() {
        List<CourseEntity> list = courseRepository.findFirst5ByOrderByCreatedAtDesc();

        List<CourseDto> listDto = new ArrayList<>();

        for(CourseEntity entity : list){
            listDto.add(this.toDto(entity));
        }

        return listDto;
    }


    @Override
    public List<CourseDto> getAllCoursesByCity(String city) {
        System.out.println("dans service");
        //List<CourseEntity> list = courseRepository.findByCityDepartureLikeOrCityArrivalLike(city, city);
        List<CourseEntity> list = courseRepository.findByCityDepartureLikeOrCityArrivalLike('%'+city+'%', '%'+city+'%');
        List<CourseDto> listDto = new ArrayList<>();

        for(CourseEntity ce : list) {
            listDto.add(this.toDto(ce));
        }
        return listDto;
    }

    @Override
    public Integer numberPageMaxCourseByUser(Integer userId) {
        List<CourseEntity> list = courseRepository.findAllByUserEntity(userRepository.findById(userId).get());
        return list.size() / 5 ;
    }

    @Override
    public List<CourseDto> getAllCoursesByUserPage(Integer page, Integer size, Integer userId) {
        UserEntity user = userRepository.findById(userId).get();
        List<CourseEntity> list = courseRepository.findAllByUserEntity(user, PageRequest.of(page, size)).getContent();

        List<CourseDto> listFinal = new ArrayList<>();

        for(CourseEntity entity: list){
            listFinal.add(this.toDto(entity));
        }
        return listFinal;
    }

    @Override
    public Integer numberPageMaxOfCourses() {
        List<CourseEntity> list = courseRepository.findAll();
        return list.size() / 12 ;
    }

    @Override
    public List<CourseDto> getAllCoursesByPages(Integer page, Integer size) {
        List<CourseEntity> list = courseRepository.findAll(PageRequest.of(page, size)).getContent();
        List<CourseDto> listFinal = new ArrayList<>();

        for(CourseEntity entity: list){
            listFinal.add(this.toDto(entity));
        }
        return listFinal;
    }

    @Override
    public Integer addCourse(LocalDateTime date, String cityDeparture, Integer departureZipCode, String streetDeparture, String cityArrival, Integer arrivalZipCode, String streetArrival, Integer numberPlace) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setDate(date);
        courseEntity.setUserEntity(userRepository.findById(10).get());
        courseEntity.setCityDeparture(cityDeparture);
        courseEntity.setDepartureZipCode(departureZipCode);
        courseEntity.setStreetDeparture(streetDeparture);
        courseEntity.setCityArrival(cityArrival);
        courseEntity.setArrivalZipCode(arrivalZipCode);
        courseEntity.setStreetArrival(streetArrival);
        courseEntity.setNumberPlace(numberPlace);
        courseEntity.setCreatedAt(LocalDateTime.now());

        courseRepository.saveAndFlush(courseEntity);
        return courseEntity.getId();
    }


}

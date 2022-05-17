package com.example.blablacat.repository;

import com.example.blablacat.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {

    List<CourseEntity> findByCityDepartureOrCityArrival(String cityDeparture, String cityArrival);

    List<CourseEntity> findAllByDeletedAtNullAndDateAfter(LocalDateTime dateMin);

    List<CourseEntity> findFirst5ByOrderByCreatedAtDesc();

}

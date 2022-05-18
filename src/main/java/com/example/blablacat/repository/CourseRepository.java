package com.example.blablacat.repository;

import com.example.blablacat.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {

    /**
     * Renvoie les Courses ayant une certaines ville en point de départ ou arrivée
     * @param cityDeparture
     * @param cityArrival
     * @return List<CourseEntity>
     */
    List<CourseEntity> findByCityDepartureOrCityArrival(String cityDeparture, String cityArrival);

    /**
     * Renvoie les Courses n'ayant pas été delete et ayant lieu après la date et l'heure actuelle
     * @param dateMin dateTime actuel
     * @return List<CourseEntity>
     */
    List<CourseEntity> findAllByDeletedAtNullAndDateAfter(LocalDateTime dateMin);

    /**
     * Renvoie les 5 derniers Courses créés
     * @return List<CourseEntity>
     */
    List<CourseEntity> findFirst5ByOrderByCreatedAtDesc();

}

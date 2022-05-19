package com.example.blablacat.services;

import com.example.blablacat.dto.CourseDto;
import com.example.blablacat.entity.CourseEntity;
import com.example.blablacat.entity.UserEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ICourseService {

    /**
     * Crée un CourseDto à partir d'un CourseEntity
     * @param entity CourseEntity à transformer
     * @return CourseDto
     */
    CourseDto toDto(CourseEntity entity);

    /**
     * Récupère toutes les courses en BDD
     * @return List de CourseDto
     */
    List<CourseDto> getAllCourse();

    /**
     * Récupère toutes les courses valides : pas avant 'aujourd'hui' et deleted_at null
     * @return list de CourseDto valides
     */
    List<CourseDto> getAllCoursesValid();

    /**
     * Récupère les 5 dernières courses crées
     * @return list de CourseDto
     */
    List<CourseDto> getLastFiveCoursesCreated();

    /**
     * Rajoute une course en BDD
     * @param date du trajet (date et heure de départ)
     * @param cityDeparture Ville de départ du trajet
     * @param departureZipCode Code postal du départ du trajet
     * @param streetDeparture Rue de départ du trajet
     * @param cityArrival Ville de d'arrivé du trajet
     * @param arrivalZipCode Code postal de l'arrivée du trajet
     * @param streetArrival Rue de l'arrivé du trajet
     * @param numberPlace Nombre de places disponibles
     * @return l'Id de la course en BDD
     */
    Integer addCourse(LocalDateTime date, String cityDeparture, Integer departureZipCode, String streetDeparture, String cityArrival, Integer arrivalZipCode, String streetArrival, Integer numberPlace);

    /**
     * Récupère en BDD tous les trajets ayant une certain
     * @param city Ville à chercher
     * @return List de CourseDto validant les critères de recherche
     */
    List<CourseDto> getAllCoursesByCity(String city);

}


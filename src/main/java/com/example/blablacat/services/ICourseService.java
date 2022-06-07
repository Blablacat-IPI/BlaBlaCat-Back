package com.example.blablacat.services;

import com.example.blablacat.dto.CourseDto;
import com.example.blablacat.dto.ReservationDto;
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
     * Récupère en BDD tous les trajets par ville
     * @param city Ville à chercher
     * @return List de CourseDto validant les critères de recherche
     */
    List<CourseDto> getAllCoursesByCity(String city);

    /**
     * Récupère en BDD tous les trajets par adresse
     * @param street Adresse a rechercher
     * @return Liste de CourseDto validant les critères de recherche
     */
    List<CourseDto> getAllCoursesByStreet(String street);

    /**
     * Récupère en BDD tous les trajets par code postal
     * @param zipcode code postal a renseigner
     * @return Liste de courseDto validant les critère de recherche
     */
    List<CourseDto> getAllCoursesByZipcode(String zipcode);

    /**
     * Calcul le nombre de page max par 12 course/page
     * @return Integer du nombre de page
     */
    Integer numberPageMaxOfCourses();

    /**
     * Permet de faire la pagination des courses
     * @param page la page voulu
     * @param size nombre d'élement par page ici 12
     * @return
     */
    List<CourseDto> getAllCoursesByPages(Integer page, Integer size);

     /** Calcule le nombre de pages pour 5 Courses/page (pour le moment)
     * @return Integer du nombre de pages
     */
    Integer numberPageMaxCourseByUser(Integer userId);

    /**
     * Renvoie les Courses créées par un User paginées
     * @param page
     * @param size
     * @return List<ReservationDto>
     */
    List<CourseDto> getAllCoursesByUserPage(Integer page, Integer size, Integer userId);


}


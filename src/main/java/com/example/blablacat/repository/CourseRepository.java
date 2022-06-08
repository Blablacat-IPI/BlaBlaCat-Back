package com.example.blablacat.repository;

import com.example.blablacat.entity.CourseEntity;
import com.example.blablacat.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {

    /**
     * Renvoie les courses dont les noms de ville correspondent au filtre city voulu
     * @param cityDeparture
     * @param cityArrival
     * @return List<CourseEntity>
     */
    List<CourseEntity> findByCityDepartureLikeOrCityArrivalLike(@Param("city") String cityDeparture, @Param("city") String cityArrival);

    /**
     * Renvoie les courses dont les noms d'adresse' correspondent au filtre street voulu
     * @param streetDeparture
     * @param streetArrival
     * @return List<CourseEntity>
     */
    List<CourseEntity> findByStreetDepartureLikeOrStreetArrivalLike(@Param("street")String streetDeparture,@Param("street") String streetArrival);

    /**
     * Renvoie les courses dont le code postal correspond au filtre zipcode voulu
     * @param zipcodeDeparture
     * @param zipcodeArrival
     * @return List<CourseEntity>
     */
    @Query(value = "select * from Courses where departure_zip_code like ?% or arrival_zip_code like ?%", nativeQuery = true)
    List<CourseEntity> getAllCoursesByZipCode(@Param("zipcode")String zipcodeDeparture,@Param("zipcode") String zipcodeArrival);

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

    /**
     * Récupère les courses créées par un User
     * @param entity
     * @return List<CourseEntity>
     */
    List<CourseEntity> findAllByUserEntity(UserEntity entity);

    /**
     * Récupère les courses crée par un User et les pagines
     * @param entity
     * @param pageable
     * @return Page<CourseEntity>
     */
    Page<CourseEntity> findAllByUserEntity(UserEntity entity, Pageable pageable);

}

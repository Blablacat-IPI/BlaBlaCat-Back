package com.example.blablacat.repository;

import com.example.blablacat.entity.CourseEntity;
import com.example.blablacat.entity.ReservationEntity;
import com.example.blablacat.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {

    /**
     * Permet d'obtenir une liste de toutes les courses réservé par un user
     * @param entity
     * @return list
     */
    List<ReservationEntity> findAllByUserEntityAndDeletedAtNullAndCourseEntity_DateAfter(UserEntity entity, LocalDateTime dateMin);

    /**
     * Permet la pagination des courses réservé par un user
     * @param entity
     * @param pageable
     * @return
     */
    Page<ReservationEntity> findAllByUserEntityAndDeletedAtNullAndCourseEntity_DateAfter(UserEntity entity, Pageable pageable, LocalDateTime dateMin);

    /**
     * Récupère toutes les réservations d'un trajet
     * @param entity CourseEntity du trajet concerné
     * @return list<ReservationEntity>
     */
    List<ReservationEntity> findAllByCourseEntity(CourseEntity entity);

    /**
     * Récupère une réservation à partir d'un trajet et d'un l'user
     * @param courseEntity Trajet concerné
     * @param userEntity User ayant réservé
     * @return ReservationEntity
     */
    ReservationEntity findByCourseEntityAndUserEntity(CourseEntity courseEntity, UserEntity userEntity);

}

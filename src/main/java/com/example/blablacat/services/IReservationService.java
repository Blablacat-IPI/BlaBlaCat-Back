package com.example.blablacat.services;

import com.example.blablacat.dto.CourseDto;
import com.example.blablacat.dto.ReservationDto;
import com.example.blablacat.entity.ReservationEntity;

import java.util.List;

public interface IReservationService {

    /**
     * Renvoie un ReservationDto créé à partir d'un ReservationEntity
     * @param reservationEntity à transformer
     * @return un ReservationDto
     */
    ReservationDto toDto(ReservationEntity reservationEntity);

    /**
     * Récupère une réservation en BDD
     * @param id de la réservation à récupérer
     * @return un ReservationDto
     */
    ReservationDto get (Integer id);

    /**
     * Rajoutes une réservation en BDD
     * @param courseDto les infos de la course auquel l'user réserve
     * @param userId de l'user qui crée la course
     * @return L'id de la réservation
     */
    Integer save(CourseDto courseDto, Integer userId);

    /**
     * Récupère toutes les réservations en BDD
     * @return List de ReservationDto
     */
    List<ReservationDto> getAllReservations();

    /**
     * Calcule le nombre de pages pour 5 réservations/page (pour le moment)
     * @return Integer du nombre de pages
     */
    Integer numberPageMaxReservationByUser(Integer userId);

    /**
     * Renvoie les Réservations d'un User paginées
     * @param page
     * @param size
     * @return List<ReservationDto>
     */
    List<ReservationDto> getAllReservationsByUserPage(Integer page, Integer size, Integer userId);

    /**
     * Verifie si une Reservation existe en BDD
     * @param id de la réservation à verifier
     * @return true ou false
     */
    Boolean exists(Integer id);

    void deleteReservation(Integer courseId, Integer userId);
}

package com.example.blablacat.services;

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
     * @param dto ReservationDto de la réservation à ajouter
     * @return Integer de l'id de la réservation
     */
    Integer save(ReservationDto dto);

    /**
     * Récupère toutes les réservations en BDD
     * @return List de ReservationDto
     */
    List<ReservationDto> getAllReservations();

    /**
     * Calcule le nombre de pages pour 3 réservations/page (pour le moment)
     * @return Integer du nombre de pages
     */
    Integer numberPageMaxReservationByUser();

    List<ReservationDto> getAllReservationsByUserPage(Integer page, Integer size);

    /**
     * Verifie si une Reservation existe en BDD
     * @param id de la réservation à verifier
     * @return true ou false
     */
    Boolean exists(Integer id);
}

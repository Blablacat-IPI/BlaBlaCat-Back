package com.example.blablacat.services;

import com.example.blablacat.dto.UserCookieDto;
import com.example.blablacat.entity.UserEntity;

public interface IAuthentificationService{

    /**
     * Permet de vérifier quand l'user se connecte, si il existe dans la BDD
     * @param email
     * @param password
     * @return boolean
     */
    Integer login(String email, String password);

    /**
     * Convertie les données username id et role en dto
     * @param entity
     * @return dto
     */
    UserCookieDto toDto(UserEntity entity);

    /**
     * Renvoie au front, les données qui vont être généré dans les cookies en fonction de l'email de l'user
     * @param email
     * @return dto des données username, id et role
     */
    UserCookieDto getInfoFromUser(String email);

}

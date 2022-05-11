package com.example.blablacat.services;

import com.example.blablacat.dto.UserDto;
import com.example.blablacat.entity.UserEntity;

import java.util.List;

public interface IUserService {

    /**
     * Renvoie un UserDto à partir d'un UserEntity
     * @param entity de l'User à transformer
     * @return UserDto
     */
    UserDto toDto(UserEntity entity);

    /**
     * Récupère tous les Users en BDD
     * @return List de UserDto
     */
    List<UserDto> getAllUsers();

    /**
     * Récupère les users valides (deleted_at = null, validate_by_admin = true)
     * @return List de UserDto
     */
    List<UserDto> getAllValidUsers();

    /**
     * Renvoie les Users dont le champs "validate_by_admin" est null
     * @return List de UsersDto
     */
    List<UserDto> getAllUnvalidUsers();

    /**
     * Efface un User de la BDD (ajouter le delete on cascade ?)
     * @param id de l'User à supprimer
     */
    void deleteUser(Integer id);

    /**
     * Suppression douce d'un User en BDD
     * Modification du champ "deleted_at"
     * @param id de l'User à modifier
     */
    void softDeleteUser(Integer id);

    /**
     * Ajoute un User en BDD
     * @param lastName nom de famille de l'User
     * @param firstName prénom de l'User
     * @param username pseudo de l'User
     * @param idCompany compagnie ID de l'User
     * @param email e-mail de l'User
     * @param password mot de passe de l'User
     * @return l'ID autogénéré de l'User en BDD
     */
    Integer addUser(String lastName, String firstName, String username, String idCompany, String email, String password );

    /**
     * Change le champs "validate_by_admin" d'un User en true
     * @param id de l'user à modifier
     * @return true si le changement a été effectué, false si la requête n'a pas fonctionnée
     */
    Boolean validateUserByAdmin(Integer id);

    /**
     * Vérifie si un User existe en BDD à partir de son id
     * @param id : id de l'user à chercher
     * @return true s'il existe, false s'il n'existe pas
     */
    Boolean checkExistById(Integer id);


}

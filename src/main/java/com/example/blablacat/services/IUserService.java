package com.example.blablacat.services;

import com.example.blablacat.dto.UserDto;
import com.example.blablacat.entity.UserEntity;

import java.util.List;

public interface IUserService {

    /**
     * Renvoie un UserDto à partir d'un UserEntity
     * @param entity de l'User à transformer
     * @return un UserDto
     */
    UserDto toDto(UserEntity entity);

    /**
     * Récupère tous les Users en BDD
     * @return list des Users trouvés
     */
    List<UserDto> getAllUsers();

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
     * Renvoie les Users dont le champs "validate_by_admin" est null
     * @return List de tous les Users remplissant les critères
     */
    List<UserDto> getAllUnvalidUsers();

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
    Integer addUsers(String lastName, String firstName, String username, String idCompany, String email, String password );

    /**
     * Change le champs "validate_by_admin" d'un User en true
     * @param dto de l'user à modifier
     * @return true si le changement a été effectué, false si la requête n'a pas fonctionnée
     */
    Boolean validateUserByAdmin(UserDto dto);

    /**
     * Vérifie si un User existe en BDD à partir de son id
     * @param id : id de l'user à chercher
     * @return true s'il existe, false s'il n'existe pas
     */
    Boolean checkExistById(Integer id);


}

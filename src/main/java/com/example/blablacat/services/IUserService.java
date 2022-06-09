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
     * Récupère un User à partir de son id
     * @param id
     * @return UserDto
     */
    UserDto getById(Integer id);

    /**
     * Vérifie si l'username de l'utilisateur est déjà utilisé dans la BDD
     * @param username
     * @return boolean
     */
    boolean checkUsernameUsed(String username);

    /**
     * Vérifie si l'id company de l'utilisateur est déjà utilisé dans la BDD
     * @param companyId
     * @return boolean
     */
    boolean checkCompanyIdUsed(String companyId);

    /**
     * Vérifie si l'emailde l'utilisateur est déjà utilisé dans la BDD
     * @param email
     * @return boolean
     */
    boolean checkEmailUsed(String email);

    /**
     * Modifie un User en BDD
     * @param dto
     */
    void updateUser(UserDto dto);

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

    /**
     * Calcule le nombre de page max des Users non validé par l'admin
     * @return Integer du nombre de page => 10 / pages
     */
    Integer numberPageMaxOfUsersNotValidate();

    /**
     * Calcule le nombre de page max des Users validé
     * @return Integer du nombre de page => 10 / pages
     */
    Integer numberPageMaxOfUsersValidate();

    /**
     * Permet de faire la pagination des Users non validés
     * @param page la page voulu
     * @param size nombre d'élements par page ici 10
     * @return
     */
    List<UserDto> getAllUsersNotValidateByPages(Integer page, Integer size);

    /**
     * Permet de faire la pagination des Users validés
     * @param page la page voulu
     * @param size nombre d'élements par page ici 10
     * @return
     */
    List<UserDto> getAllUsersValidateByPages(Integer page, Integer size);


    String getUserEmailByUsername(String driverUsername);
}

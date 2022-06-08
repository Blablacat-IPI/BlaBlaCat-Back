package com.example.blablacat.repository;

import com.example.blablacat.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {


    /**
     * Récupère les Users avec validate_by_admin = true + deleted_at = null
     * @return List de UserEntity
     */
    List<UserEntity> findAllByValidateAdminTrueAndDeletedAtNull();

    /**
     * Permet de faire la pagination des Users validée par l'admin
     * @param pageable
     * @return
     */
    Page<UserEntity> findAllByValidateAdminTrueAndDeletedAtNull(Pageable pageable);

    /**
     * Récupère les Users avec valid_by_admin = null
     * @return List de UserEntity
     */
    List<UserEntity> findAllByValidateAdminNull();

    /**
     * Permet de faire la pagination des Users non validée par l'admin
     * @param pageable
     * @return
     */
    Page<UserEntity> findAllByValidateAdminNull(Pageable pageable);

    /**
     * Check si l'username est déjà utilisé dans la BDD
     * @param username
     * @return
     */
    boolean existsByUsername(String username);

    /**
     * Check si l'id company existe dans la BDD
     * @param companyId
     * @return
     */
    boolean existsByIdCompany(String companyId);

    /**
     * Check si l'email existe dans la bdd
     * @param email
     * @return
     */
    boolean existsByEmail(String email);

    /**
     * Issu de l'authentification, permet de vérifier si l'email et le mdp de l'user qui se connecte existe dans la BDD
     * @param email
     * @param password
     * @return
     */
    boolean existsByEmailAndPassword(String email, String password);

    /**
     * Permet d'avoir des données d'un user en fonction de son email
     * @param email
     * @return
     */
    UserEntity getByEmail(String email);



}

package com.example.blablacat.repository;

import com.example.blablacat.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    /**
     * Récupère un User en BDD à partir de son username
     * @param username
     * @return l'user
     */
    Optional<UserEntity> findByUsername(String username);

    /**
     * Récupère en BDD tous les Users qui ont le champ valid_by_admin null
     * @return une List de UserEntity
     */
    List<UserEntity> findAllByValidateAdminNull();





}

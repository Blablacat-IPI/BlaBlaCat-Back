package com.example.blablacat.repository;

import com.example.blablacat.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {


    /**
     * Récupère les Users avec validate_by_admin = true + deleted_at = null
     * @return List de UserEntity
     */
    List<UserEntity> findAllByValidateAdminTrueAndDeletedAtNull();

    Page<UserEntity> findAllByValidateAdminTrueAndDeletedAtNull(Pageable pageable);

    /**
     * Récupère les Users avec valid_by_admin = null
     * @return List de UserEntity
     */
    List<UserEntity> findAllByValidateAdminNull();

    Page<UserEntity> findAllByValidateAdminNull(Pageable pageable);

    boolean existsByUsername(String username);

    boolean existsByIdCompany(String companyId);

    boolean existsByEmail(String email);

    boolean existsByEmailAndPassword(String email, String password);

    UserEntity getByEmail(String email);



}

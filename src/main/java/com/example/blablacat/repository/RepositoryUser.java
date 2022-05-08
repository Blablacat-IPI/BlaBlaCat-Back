package com.example.blablacat.repository;

import com.example.blablacat.entity.UserEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RepositoryUser extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUsername(String username);
    List<UserEntity> findAllByValidateAdminNull();

    //@Modifying
    //@Query(value = "UPDATE Users SET validate_by_admin = ?1 WHERE username = ?2", nativeQuery = true)
    //void userValidateByAdmin(Boolean valeur, String username);


}

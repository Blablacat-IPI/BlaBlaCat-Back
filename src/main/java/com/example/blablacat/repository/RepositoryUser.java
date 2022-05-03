package com.example.blablacat.repository;

import com.example.blablacat.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends JpaRepository<UserEntity, Integer> {
}

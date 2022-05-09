package com.example.blablacat.repository;

import com.example.blablacat.entity.UserHasCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHasCourseRepository extends JpaRepository<UserHasCourseEntity, Integer> {
}

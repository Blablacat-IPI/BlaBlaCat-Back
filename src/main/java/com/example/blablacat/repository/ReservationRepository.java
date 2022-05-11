package com.example.blablacat.repository;

import com.example.blablacat.entity.CourseEntity;
import com.example.blablacat.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {

}

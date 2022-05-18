package com.example.blablacat.repository;

import com.example.blablacat.entity.ReservationEntity;
import com.example.blablacat.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {

    List<ReservationEntity> findAllByUserEntity(UserEntity entity);
    Page<ReservationEntity> findAllByUserEntity(UserEntity entity, Pageable pageable);

}

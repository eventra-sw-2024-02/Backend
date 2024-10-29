package com.example.demo.repository;

import com.example.demo.entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityEntity,Long>{
    Optional<ActivityEntity> findByBusiness_Id(Long id);
}

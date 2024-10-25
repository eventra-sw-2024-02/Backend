package com.example.demo.repository;

import com.example.demo.entity.TicketsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<TicketsEntity,Long> {
    List<TicketsEntity> findByEvent_Id(Long eventId);
}

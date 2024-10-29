package com.example.demo.controller.activity.request;

import com.example.demo.controller.ticket.request.TickeSimpleRequest;

import java.time.LocalDateTime;
import java.util.List;

public record ActivityFullRequest(
        Long id,
        String name,
        String description,
        String photo,
        String location,
        List<String> tags,
        List<LocalDateTime> fechas_eventos,
        List<TickeSimpleRequest> tickets,
        Long businessId
) {
}


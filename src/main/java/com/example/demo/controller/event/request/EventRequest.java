package com.example.demo.controller.event.request;


import java.time.LocalDateTime;

public record EventRequest(
        String eventName,
        String eventDescription,
        String eventLocation,
        String photo,
        LocalDateTime date,
        Long businessId // ID del negocio asociado
) {}

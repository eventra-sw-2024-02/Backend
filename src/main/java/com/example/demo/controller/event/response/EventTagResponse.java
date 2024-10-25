package com.example.demo.controller.event.response;

import com.example.demo.controller.event.request.TagRequest;
import com.example.demo.entity.enums.EventType;

import java.time.LocalDateTime;
import java.util.List;

public record EventTagResponse(
        Long id,
        String eventName,
        String eventDescription,
        String eventLocation,
        String photo,
        LocalDateTime date,
        EventType eventType,
        List<TagRequest> eventTags,
        Long businessId
){ }

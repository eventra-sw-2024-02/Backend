package com.example.demo.controller.event.response;

import com.example.demo.controller.event.request.TagRequest;
import com.example.demo.entity.enums.ActivityType;

import java.time.LocalDateTime;
import java.util.List;

public record EventTagResponse(
        Long id,
        String eventName,
        String eventDescription,
        String eventLocation,
        String photo,
        LocalDateTime date,
        ActivityType activityType,
        List<TagRequest> eventTags,
        Long businessId
){ }

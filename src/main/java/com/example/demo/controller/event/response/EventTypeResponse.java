package com.example.demo.controller.event.response;

import com.example.demo.entity.enums.ActivityType;

public record EventTypeResponse (
        ActivityType activityType
) {
}

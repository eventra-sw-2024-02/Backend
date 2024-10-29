package com.example.demo.controller.activity.request;

import com.example.demo.entity.enums.ActivityType;

import java.util.List;

public record ActivityTypeUpdate (
        List<Long> ids,
        ActivityType activityType
){
}

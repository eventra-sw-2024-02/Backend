package com.example.demo.controller.activity;

import com.example.demo.controller.activity.request.ActivityFullRequest;
import com.example.demo.entity.ActivityEntity;
import com.example.demo.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityEntity> createActivity(@RequestBody ActivityFullRequest activityFullRequest) {
        ActivityEntity activity = activityService.createActivity(activityFullRequest);
        return ResponseEntity.ok(activity);
    }

    @GetMapping
    public ResponseEntity<List<ActivityFullRequest>> getAllActivities() {
        List<ActivityFullRequest> lista=activityService.getAllActivities();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityFullRequest> getActivityById(@PathVariable Long id) {
        ActivityFullRequest activity = activityService.getActivityById(id);
        return ResponseEntity.ok(activity);
    }
}

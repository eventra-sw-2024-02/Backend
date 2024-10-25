package com.example.demo.controller.event.request;

import java.time.LocalDateTime;
import java.util.List;

public record EventCompleteRequest (
        String eventName,
        String eventDescription,
        String eventLocation,
        String photo,
        LocalDateTime date,
        Long businessId,
        List<TagRequest> tags
) {
}

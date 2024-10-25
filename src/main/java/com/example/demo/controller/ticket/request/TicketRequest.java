package com.example.demo.controller.ticket.request;

import java.math.BigDecimal;

public record TicketRequest(
        String name,
        String color,

        BigDecimal price,
        Integer quantity,
        Long event_id
) {
}

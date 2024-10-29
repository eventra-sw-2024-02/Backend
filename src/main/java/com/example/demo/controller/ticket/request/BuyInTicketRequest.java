package com.example.demo.controller.ticket.request;

import com.example.demo.entity.enums.MethodPayment;

public record BuyInTicketRequest(
        Long idTicket,
        Long idClient,
        MethodPayment methodPayment
) {
}

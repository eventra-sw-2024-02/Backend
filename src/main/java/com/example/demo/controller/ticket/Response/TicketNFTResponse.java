package com.example.demo.controller.ticket.Response;

import java.util.UUID;

public record TicketNFTResponse(
        UUID uuid,
        String actualOwnerPublicDirection,
        String nft,
        Long ticket_id,
        Long client_id
) {
}

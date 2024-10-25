package com.example.demo.service;

import com.example.demo.controller.ticket.Response.TicketNFTResponse;
import com.example.demo.entity.TicketsEntity;
import com.example.demo.entity.TicketsNFT;
import com.example.demo.repository.TicketsNFTRepository; // Asegúrate de tener este repositorio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketsNFTService {

    @Autowired
    private TicketsNFTRepository ticketsNFTRepository;

    public TicketsNFT createTicketsNFT(TicketsNFT ticketsNFT) {
        return ticketsNFTRepository.save(ticketsNFT);
    }

    public List<TicketsNFT> getAllTicketsNFTs() {
        return ticketsNFTRepository.findAll();
    }

    public List<TicketsNFT> createMultipleTicketsNFTs(TicketsEntity ticket) {
        if (ticket.getQuantity() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
        }
        List<TicketsNFT> ticketsNFTs = new ArrayList<>();

        for (int i = 0; i < ticket.getQuantity(); i++) {
            TicketsNFT ticketsNFT = new TicketsNFT();
            ticketsNFT.setTicket(ticket);
            ticketsNFTs.add(ticketsNFT);
        }

        return ticketsNFTRepository.saveAll(ticketsNFTs);
    }

    public List<TicketNFTResponse> getTicketsNFTsByTicketId(Long ticketId) {
        List<TicketsNFT> ticketsNFTs = ticketsNFTRepository.findByTicket_Id(ticketId);
        return ticketsNFTs.stream()
                .map(ticketNFT -> new TicketNFTResponse(
                        ticketNFT.getUuid(),
                        ticketNFT.getActualOwnerPublicDirection(),
                        ticketNFT.getNft(),
                        ticketNFT.getTicket().getId(), // Asumiendo que el ticket está asociado
                        ticketNFT.getClient() != null ? ticketNFT.getClient().getId() : null // Verifica si el cliente no es null
                ))
                .toList(); // Si usas Java 11 o superior
    }

}

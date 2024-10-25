package com.example.demo.service;

import com.example.demo.controller.ticket.Response.TicketNFTResponse;
import com.example.demo.controller.ticket.request.TicketRequest;
import com.example.demo.entity.TicketsEntity;
import com.example.demo.entity.TicketsNFT;
import com.example.demo.repository.TicketRepository; // Asegúrate de tener este repositorio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private EventService eventService;
    @Autowired
    private TicketsNFTService ticketsNFTService;


    public TicketsEntity createTicket(TicketRequest ticketRequest) {
        TicketsEntity ticket = new TicketsEntity();
        ticket.setName(ticketRequest.name());
        ticket.setColor(ticketRequest.color());
        ticket.setPrice(ticketRequest.price());
        ticket.setQuantity(ticketRequest.quantity());
        ticket.setEvent(eventService.getEventById(ticketRequest.event_id()).get());
        ticket=ticketRepository.save(ticket);

        ticketsNFTService.createMultipleTicketsNFTs(ticket);

        return ticket;
    }


    public List<TicketsEntity> getAllTickets() {
        return ticketRepository.findAll();
    }

    public List<TicketsEntity> getTicketsByEventId(Long eventId) {
        return ticketRepository.findByEvent_Id(eventId); // Llama al método del repositorio
    }

    //ARREGLAR ESTO PLS
    public List<TicketNFTResponse> getTicketsNFTsByTicketId(Long ticketId) {
        return ticketsNFTService.getTicketsNFTsByTicketId(ticketId);
    }
}

package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name="ticket_nft")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TicketsNFT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private UUID uuid;

    private String actualOwnerPublicDirection;

    private String nft;

    @ManyToOne
    @JoinColumn(name="ticket_id",referencedColumnName = "id")
    private TicketsEntity ticket;

    @ManyToOne
    @JoinColumn(name="client_id",referencedColumnName = "id")
    private ClientEntity client;

    @PrePersist
    protected void onCreate() {
        uuid = UUID.randomUUID();
    }

}

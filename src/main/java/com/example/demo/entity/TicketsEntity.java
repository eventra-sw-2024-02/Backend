package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name="ticket")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TicketsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private String color;


    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    private Integer actualquantity = 0;

    @ManyToOne
    @JoinColumn(name="event_id",referencedColumnName = "id")
    private Event event;

}

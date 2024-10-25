package com.example.demo.entity;

import com.example.demo.entity.enums.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name="event")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String EventName;

    private LocalDateTime dateTime;

    private String EventDescription;

    private String photo;

    @Enumerated(EnumType.STRING)
    private EventType eventType=EventType.NONE;

    private String EventLocation; // ubicacion maps link

    @ManyToOne
    @JoinColumn(name="business_id",referencedColumnName = "id")
    private Business business;
}

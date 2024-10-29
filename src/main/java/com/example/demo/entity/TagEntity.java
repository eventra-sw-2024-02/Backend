package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="tag")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nameTag;

    @ManyToOne
    @JoinColumn(name="event_id",referencedColumnName = "id")
    private ActivityEntity activity;
}

package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="business")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String businessName;

    @Column(nullable = false)
    private String Ruc;

    private String Address;

    private String ReasonSocial;

    private String ComercialName;

    private String Category;

    @OneToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private UserEntity user;
}

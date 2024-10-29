package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name="client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String realName;

    private LocalDate birthDate;

    private Integer age;

    private String dni;

    private String country;

    private String gender;

    private String Direction;

    private String phone;

    @OneToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private UserEntity user;
}

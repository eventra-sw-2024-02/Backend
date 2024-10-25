package com.example.demo.entity;

import com.example.demo.entity.enums.UserRole;
import com.example.demo.entity.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;

@Table(name="user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    private String photo;

    @Enumerated(EnumType.STRING)
    private UserRole role=UserRole.CLIENT;

    @Enumerated(EnumType.STRING)
    private UserStatus status=UserStatus.ACTIVE;

    @Column(unique=true)
    private String publicDirection; //direccion publica para la blockchain
}

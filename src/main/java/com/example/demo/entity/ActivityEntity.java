package com.example.demo.entity;

import com.example.demo.entity.enums.ActivityType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="activity")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ActivityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    private String description;
    private String photo;

    @Enumerated(EnumType.STRING)
    private ActivityType activityType = ActivityType.NONE;

    private String ActivityLocation;

    @ManyToOne
    @JoinColumn(name="business_id",referencedColumnName = "id")
    private Business business;
}

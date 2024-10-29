package com.example.demo.entity;

import com.example.demo.entity.enums.MethodPayment;
import com.example.demo.entity.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name="transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MethodPayment methodPayment;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus = TransactionStatus.APPROVED;

    private Long ticketId;

    private BigDecimal fee;
}

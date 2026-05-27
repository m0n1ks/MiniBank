package com.example.MiniBank.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne  // много транзакций у одного счёта
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(nullable = false)
    private BigDecimal amount; // сумма операции

    @Column(nullable = false)
    private String type; // DEPOSIT (пополнение) или WITHDRAWAL (снятие)

    private String description; // комментарий к операции

    @CreationTimestamp
    private LocalDateTime createdAt;
}
package com.example.MiniBank.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne  // много счетов может быть у одного клиента
    @JoinColumn(name = "client_id") // это и есть внешний ключ client_id в таблице
    private Client client;

    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO; // BigDecimal для денег — точнее чем double

    @Column(nullable = false)
    private String currency = "RUB";

    @Column(nullable = false)
    private String status = "ACTIVE";

    @CreationTimestamp
    private LocalDateTime createdAt;
}
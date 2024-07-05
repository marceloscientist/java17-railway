package com.santander.challenge.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "accounts")
public record Account(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        @Column(unique = true)
        String number,
        String agency,

        @Column(scale = 13, precision = 2)
        BigDecimal balance,
        @Column(name = "additional_limit",scale = 13, precision = 2)
        BigDecimal limit) {

    // Construtor sem argumentos para JPA
    public Account() {
        this(null, null, null, null, null);
    }
}

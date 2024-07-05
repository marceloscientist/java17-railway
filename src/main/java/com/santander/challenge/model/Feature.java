package com.santander.challenge.model;

import jakarta.persistence.*;

@Entity(name = "features")
public record Feature(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        String icon,
        String description) {

    // Construtor sem argumentos para JPA
    public Feature() {
        this(null, null, null);
    }
}

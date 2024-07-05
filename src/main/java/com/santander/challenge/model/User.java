package com.santander.challenge.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "users")
public record User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        String name,

        @OneToOne(cascade = CascadeType.ALL)
        Account account,
        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        List<Feature> features) {

        public User() {
            this(null, null, null, null);
        }
}

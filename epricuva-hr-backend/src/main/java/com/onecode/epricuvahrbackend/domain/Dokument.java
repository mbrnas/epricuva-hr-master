package com.onecode.epricuvahrbackend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Dokument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;
    private String tip; // Ugovor, Izvještaj, Zapisnik
    private String putanja;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zgrada_id")
    private Zgrada zgrada;
}

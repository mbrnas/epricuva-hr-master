package com.onecode.epricuvahrbackend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;

@Entity
public class Stan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brojStana;
    private int kat;
    private double kvadratura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vlasnik_id")
    private Vlasnik vlasnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zgrada_id")
    private Zgrada zgrada;
}

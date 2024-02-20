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

import java.util.Date;

@Entity
@Getter
@Setter
public class Racun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date datumIzdavanja;
    private Date datumDospijeca;
    private double iznos;
    private String razdoblje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vlasnik_id")
    private Vlasnik vlasnik;
}

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
public class Odrzavanje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vrstaRadova;
    private Date datumIzvodjenja;
    private double troskovi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zgrada_id")
    private Zgrada zgrada;
}

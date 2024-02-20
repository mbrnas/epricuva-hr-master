package com.onecode.epricuvahrbackend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Zgrada {
    @Id
    private Long id;
    private String adresa;
    private String ulica;
    private String drzava;
    private String godinaIzgradnje;
    private int brojStanova;
    private int brojKatova;
}

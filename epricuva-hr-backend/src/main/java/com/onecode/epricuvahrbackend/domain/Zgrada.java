package com.onecode.epricuvahrbackend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Zgrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adresa;
    private String ulica;
    private String drzava;
    private String godinaIzgradnje;
    private int brojStanova;
    private int brojKatova;

    @OneToMany(mappedBy = "zgrada", fetch = FetchType.LAZY)
    private List<Stan> stanovi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "upravitelj_id")
    private Upravitelj upravitelj;
}

package com.onecode.epricuvahrbackend.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @Column(name = "year_of_construction")
    private String yearOfConstruction;
    @Column(name = "number_of_apartments")
    private int numberOfApartments;
    @Column(name = "number_of_floors")
    private int numberOfFloors;

    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
    private List<Apartment> apartments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private BuildingManager manager;
}

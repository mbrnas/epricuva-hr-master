package com.onecode.epricuvahrbackend.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "personal_id")
    private String personalId;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<Apartment> apartments;
}

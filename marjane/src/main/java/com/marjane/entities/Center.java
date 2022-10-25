package com.marjane.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ville;

    @OneToOne
    private Admin admin;

    @OneToMany
    private List<ChefRayon> chefRayons;


    @OneToMany(mappedBy = "center")
    private List<Promotion> promotions;

}

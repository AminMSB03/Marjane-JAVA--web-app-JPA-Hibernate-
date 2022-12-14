package com.marjane.module;


import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Promotion> promotions;

    @OneToMany(mappedBy = "category")
    private List<ChefRayon> chefRayonList;

}

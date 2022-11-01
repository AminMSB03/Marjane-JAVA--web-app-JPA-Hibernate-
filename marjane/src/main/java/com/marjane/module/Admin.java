package com.marjane.module;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;

    @ManyToOne
    private Center center;

    @ManyToOne
    private AdminGen adminGen;

    @OneToMany(mappedBy = "chefAdmin")
    private List<ChefRayon> chefRayonList;





}

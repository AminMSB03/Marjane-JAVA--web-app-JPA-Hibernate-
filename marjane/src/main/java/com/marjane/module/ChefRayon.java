package com.marjane.module;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class ChefRayon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String email;
    private String password;

    @ManyToOne
    private Admin chefAdmin;

    @ManyToOne
    private Center center;

    @ManyToOne
    private Category category;




}

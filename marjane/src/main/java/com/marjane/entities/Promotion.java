package com.marjane.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    private Double promo;
    @Column(columnDefinition = "int default 0")
    private int status;



    @ManyToOne
    private Category category;

    @ManyToOne
    private Center center;

}

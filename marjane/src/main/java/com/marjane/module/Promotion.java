package com.marjane.module;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SelectBeforeUpdate;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    private Date endDate;
    private Double promo;
    private String description;

    @Column(columnDefinition = "int default 0")
    private int status;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Center center;

}

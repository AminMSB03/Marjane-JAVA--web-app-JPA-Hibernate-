package com.marjane.module;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @NoArgsConstructor  @AllArgsConstructor
public class AdminGen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long adminId;
    private String email;
    private String password;

    @OneToMany(mappedBy = "adminGen")
    private List<Admin> adminList;
}

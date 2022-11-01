package com.marjane.dao.admin;

import com.marjane.module.Admin;

import java.util.List;
import java.util.Optional;

public interface IAdminDao {

    public void save(Admin admin);
    public List<Admin> findAll();

    public Optional<Admin> getAdminByEmail(String email);

    public Optional<Admin> getAdminById(Long id);


}

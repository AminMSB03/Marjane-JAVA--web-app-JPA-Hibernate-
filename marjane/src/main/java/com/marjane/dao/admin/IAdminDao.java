package com.marjane.dao.admin;

import com.marjane.entities.Admin;

import java.util.List;

public interface IAdminDao {

    public void save(Admin admin);
    public List<Admin> findAll(Admin admin);
}

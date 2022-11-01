package com.marjane.dao.adminGen;

import com.marjane.module.AdminGen;

import java.util.Optional;

public interface IAdminGenDao {

    public Optional<AdminGen> getAdminByEmail(String email);

    public void save(AdminGen adminGen);



}

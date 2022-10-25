package com.marjane.dao.adminGen;

import com.marjane.entities.AdminGen;
import com.marjane.entities.Promotion;

import java.util.Optional;

public interface IAdminGenDao {

    public Optional<AdminGen> getAdminByEmail(String email);

    public void save(AdminGen adminGen);

}

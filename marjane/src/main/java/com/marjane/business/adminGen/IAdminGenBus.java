package com.marjane.business.adminGen;

import com.marjane.module.Admin;
import com.marjane.module.Center;

import java.util.List;

public interface IAdminGenBus {
    public void addAdmin(String email, String password,Long idCenter) throws Exception;

    public Boolean Login(String email, String password) throws Exception;

    public List<Admin> getAllAdmins();

    public void addAdminGen(String email, String password) throws Exception;


    List<Center> getAllCenters();
}

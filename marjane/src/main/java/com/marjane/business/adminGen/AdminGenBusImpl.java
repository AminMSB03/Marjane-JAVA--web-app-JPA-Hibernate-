package com.marjane.business.adminGen;

import com.marjane.dao.admin.AdminDaoImpl;
import com.marjane.entities.Admin;

public class AdminGenBusImpl implements IAdminGenBus {

    @Override
    public void addAdmin(String email, String password) {
        Admin admin = new Admin();
        admin.setEmail(email);
        admin.setPassword(password);
        AdminDaoImpl adminDao = new AdminDaoImpl();
        adminDao.save(admin);
    }

    @Override
    public Boolean Login(String email, String password) {
        return null;
    }
}

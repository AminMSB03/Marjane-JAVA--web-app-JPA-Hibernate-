package com.marjane.business.adminGen;

import com.marjane.dao.admin.AdminDaoImpl;
import com.marjane.dao.admin.IAdminDao;
import com.marjane.dao.adminGen.AdminGenDaoImpl;
import com.marjane.dao.adminGen.IAdminGenDao;
import com.marjane.dao.center.CenterDaoImp;
import com.marjane.module.Admin;
import com.marjane.module.AdminGen;
import com.marjane.module.Center;
import com.marjane.helpers.Encryptor;

import java.util.List;
import java.util.Optional;

public class AdminGenBusImpl implements IAdminGenBus {

    @Override
    public void addAdmin(String email, String password,Long idCenter) throws Exception {
        Admin admin = new Admin();
        admin.setEmail(email);

        Center center = null;
        CenterDaoImp centerDaoImp = new CenterDaoImp();
        Optional<Center> centerOptional = centerDaoImp.find(idCenter);
        if(centerOptional.isPresent()){
            center = centerOptional.get();
        }
        admin.setCenter(center);
        String hashedPassword = Encryptor.encryptPassword(password);

        admin.setPassword(hashedPassword);
        AdminDaoImpl adminDao = new AdminDaoImpl();
        adminDao.save(admin);
    }

    // Login for the admin General
    @Override
    public Boolean Login(String email, String password) throws Exception {
        IAdminGenDao adminGenDao = new AdminGenDaoImpl();
        Optional<AdminGen> adminGen = adminGenDao.getAdminByEmail(email);
        if(adminGen.isPresent() ){
            AdminGen adminGenRes = adminGen.get();
            if(Encryptor.checkPassword(password,adminGenRes.getPassword())) return true;
        }
        return false;
    }


    // Get all admins of Marjane center's
    @Override
    public List<Admin> getAllAdmins() {
        IAdminDao adminDao = new AdminDaoImpl();
        List<Admin> adminList= adminDao.findAll();
        return adminList;
    }

    // To add a general admin
    @Override
    public void addAdminGen(String email, String password) throws Exception {
        AdminGen adminGen = new AdminGen();
        adminGen.setEmail(email);

        String hashedPassword = Encryptor.encryptPassword(password);

        adminGen.setPassword(hashedPassword);
        IAdminGenDao adminDao = new AdminGenDaoImpl();
        adminDao.save(adminGen);
    }


    @Override
    public List<Center> getAllCenters(){
        CenterDaoImp centerDaoImp = new CenterDaoImp();
        return centerDaoImp.getCenterList();
    }


}

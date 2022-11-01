package com.marjane.business.chefrayon;

import com.marjane.module.Admin;
import com.marjane.module.Promotion;

import java.util.List;

public interface IChefRayonBus {
    public void addAdmin(String email, String password) throws Exception;

    public Long Login(String email, String password) throws Exception;

    public List<Admin> getAllAdmins();

    public void addAdminGen(String email, String password) throws Exception;


    public List<Promotion> getPromotions(Long idChef)throws Exception;

    public void actOnPromo(Long idPromotion, int status, String desc);



}

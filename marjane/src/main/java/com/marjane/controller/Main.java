package com.marjane.controller;


import com.marjane.business.chefrayon.ChefRayonBusImpl;
import com.marjane.dao.admin.AdminDaoImpl;
import com.marjane.dao.chefRayon.ChefRayonDaoImp;
import com.marjane.dao.promotion.PromotionDaoImpl;
import com.marjane.module.Admin;
import com.marjane.module.ChefRayon;
import com.marjane.module.Promotion;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {

        //AdminGenBusImpl adminGenBus = new AdminGenBusImpl();
        //adminGenBus.addAdminGen("adminGen@gmail.com","adminGen123");
        //Boolean result = adminGenBus.Login("adminGen@gmail.com","adminGen123");
        //List<Admin> adminList = adminGenBus.getAllAdmins();
        //adminList.stream().forEach(el-> out.println(el.getCenter().getVille()));

        //adminGenBus.addAdmin("amine@amine.com","admin123", Long.valueOf(1));

        //CenterDaoImp centerDaoImp = new CenterDaoImp();
        //out.println( centerDaoImp.find(Long.valueOf(1)));;

        //AdminBusImp adminBusImp = new AdminBusImp();
        //adminBusImp.addChefRayon("chefRayon@gmail.com","chef123",1L,1L);
        /*
        LocalDate date = LocalDate.parse("2022-10-28");
        Date startDate =Date.valueOf(date);
        LocalDate date2 = LocalDate.parse("2022-10-30");
        Date endDate =Date.valueOf(date);

        Admin admin = null;
        AdminDaoImpl adminDao = new AdminDaoImpl();
        Optional<Admin> optionalAdmin = adminDao.getAdminById(2L);
        if(optionalAdmin.isPresent()){
            admin = optionalAdmin.get();
        }

        System.out.println("--------------------------------");

        System.out.println(admin.getCenter().getId());
        System.out.println(admin.getCenter().getVille());

        PromotionDaoImpl promotionDao = new PromotionDaoImpl();
        List<Promotion> promotions =  promotionDao.findCenterPromotions(admin.getCenter());


        Admin finalAdmin = admin;
        List<Promotion> promotions2 = promotions.stream().filter(el->{
            return el.getCenter().getId()==finalAdmin.getCenter().getId();
        }).collect(Collectors.toList());

        System.out.println(promotions.size());

        System.out.println(promotions2.size());


        ChefRayonBusImpl chefRayonBus = new ChefRayonBusImpl();
        Long id = chefRayonBus.Login("test2@test.com","test2123");
        System.out.println(id);
        List<Promotion> promotions = chefRayonBus.getPromotions(4L);

        promotions.stream().forEach(el-> System.out.println(el.getId()));
         */
        ChefRayonBusImpl chefRayonBus = new ChefRayonBusImpl();
        chefRayonBus.actOnPromo(5L,0,null);




    }
}

package com.marjane.business.admin;

import com.marjane.dao.admin.AdminDaoImpl;
import com.marjane.dao.admin.IAdminDao;
import com.marjane.dao.category.CategoryDaoImp;
import com.marjane.dao.center.CenterDaoImp;
import com.marjane.dao.chefRayon.ChefRayonDaoImp;
import com.marjane.dao.chefRayon.IChefRayonDao;
import com.marjane.dao.promotion.PromotionDaoImpl;
import com.marjane.module.*;
import com.marjane.helpers.Encryptor;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class AdminBusImp implements IAdminBus {


    public void addPromotion(Long idCategory,Long idAdmin ,double promo, Date date,Date endDate) {

        // get the category
        Category category = null;
        CategoryDaoImp categoryDaoImp = new CategoryDaoImp();
        Optional<Category> categoryOptional = categoryDaoImp.find(idCategory);
        if(categoryOptional.isPresent()){
            category = categoryOptional.get();
        }

        // get the center
        Admin admin = null;
        AdminDaoImpl adminDao = new AdminDaoImpl();
        Optional<Admin> optionalAdmin = adminDao.getAdminById(idAdmin);
        if(optionalAdmin.isPresent()){
            admin = optionalAdmin.get();
        }

        Promotion promotion = new Promotion();
        promotion.setCategory(category);
        promotion.setPromo(promo);
        promotion.setCenter(admin.getCenter());
        promotion.setDate(date);
        promotion.setEndDate(endDate);

        PromotionDaoImpl promotionDao = new PromotionDaoImpl();
        promotionDao.save(promotion);

    }

    @Override
    public void addChefRayon(String email, String password, Long categoryId,Long idAdmin) throws Exception {


        Admin admin = null;
        AdminDaoImpl adminDao = new AdminDaoImpl();
        Optional<Admin> optionalAdmin = adminDao.getAdminById(idAdmin);
        if(optionalAdmin.isPresent()){
            admin = optionalAdmin.get();
        }

        Category category = null;
        CategoryDaoImp categoryDaoImp = new CategoryDaoImp();
        Optional<Category> categoryOptional = categoryDaoImp.find(categoryId);
        if(categoryOptional.isPresent()){
            category = categoryOptional.get();
        }


        ChefRayon chefRayon = new ChefRayon();
        ChefRayonDaoImp chefRayonDaoImp = new ChefRayonDaoImp();
        chefRayon.setEmail(email);
        chefRayon.setCenter(admin.getCenter());
        chefRayon.setCategory(category);
        chefRayon.setChefAdmin(admin);

        String hashedPassword = Encryptor.encryptPassword(password);

        chefRayon.setPassword(hashedPassword);
        //AdminDaoImpl adminDao = new AdminDaoImpl();
        chefRayonDaoImp.save(chefRayon);
    }


    @Override
    public List<ChefRayon> getAllChefs() {
        IChefRayonDao chefRayonDao = new ChefRayonDaoImp();
        List<ChefRayon> chefRayonList = chefRayonDao.findAll();
        return chefRayonList;
    }




    @Override
    public Long Login(String email, String password) throws Exception {
        IAdminDao adminDao = new AdminDaoImpl();
        Optional<Admin> admin = adminDao.getAdminByEmail(email);
        if(admin.isPresent() ){
            Admin admin1 = admin.get();
            if(Encryptor.checkPassword(password,admin1.getPassword())) return admin1.getId();
        }
        return null;
    }


    @Override
    public List<Center> getAllCenters(){
        CenterDaoImp centerDaoImp = new CenterDaoImp();
        return centerDaoImp.getCenterList();
    }

    @Override
    public List<Category> getCategories(){
        CategoryDaoImp categoryDaoImp = new CategoryDaoImp();
        return categoryDaoImp.getCategories();
    }

    @Override
    public List<Promotion> getPromotionsAdminGen() {
        return null;
    }


    @Override
    public List<Promotion> getPromotions(Long idAdmin) {

        Admin admin = null;
        AdminDaoImpl adminDao = new AdminDaoImpl();
        Optional<Admin> optionalAdmin = adminDao.getAdminById(idAdmin);
        if(optionalAdmin.isPresent()){
            admin = optionalAdmin.get();
        }

        PromotionDaoImpl promotionDao = new PromotionDaoImpl();
        return promotionDao.findCenterPromotions(admin.getCenter());
    }


}

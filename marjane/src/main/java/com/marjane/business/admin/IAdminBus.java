package com.marjane.business.admin;

import com.marjane.module.Category;
import com.marjane.module.Center;
import com.marjane.module.ChefRayon;
import com.marjane.module.Promotion;

import java.sql.Date;
import java.util.List;

public interface IAdminBus {
    public void addPromotion(Long idCategory,Long idCenter ,double promo, Date date,Date endDate);

    public void addChefRayon(String email, String password, Long categoryId,Long idAdmin) throws Exception;

    public Long Login(String email, String password) throws Exception;

    public List<ChefRayon> getAllChefs();

    public List<Center> getAllCenters();

    public List<Category> getCategories();

    public List<Promotion> getPromotionsAdminGen();

    public List<Promotion> getPromotions(Long idAdmin);
}

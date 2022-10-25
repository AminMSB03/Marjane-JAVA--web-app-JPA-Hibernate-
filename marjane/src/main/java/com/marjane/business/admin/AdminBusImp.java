package com.marjane.business.admin;

import com.marjane.dao.category.CategoryDaoImp;
import com.marjane.dao.center.CenterDaoImp;
import com.marjane.entities.Category;
import com.marjane.entities.Center;
import com.marjane.entities.Promotion;

import java.util.Date;
import java.util.Optional;

public class AdminBusImp {


    public void addPromotion(Long id, double promo, Date date) {

        // get the category
        Category category = null;
        CategoryDaoImp categoryDaoImp = new CategoryDaoImp();
        Optional<Category> categoryOptional = categoryDaoImp.find(id);
        if(categoryOptional.isPresent()){
            category = categoryOptional.get();
        }

        // get the center
        Center center = null;
        CenterDaoImp centerDaoImp = new CenterDaoImp();
        Optional<Center> centerOptional = centerDaoImp.find(id);
        if(centerOptional.isPresent()){
            center = centerOptional.get();
        }

        Promotion promotion = new Promotion();
        promotion.setCategory(category);
        promotion.setPromo(promo);
        promotion.setCenter(center);
        promotion.setDate(date);
    }
}

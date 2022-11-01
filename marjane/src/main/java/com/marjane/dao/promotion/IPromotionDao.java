package com.marjane.dao.promotion;

import com.marjane.module.Center;
import com.marjane.module.Promotion;

import java.util.List;

public interface IPromotionDao {
    public void save(Promotion promotion);
    public List<Promotion> findAll();
    public List<Promotion> findByDate();
    public void update(Long idPromotion,int status, String desc);


    public List<Promotion> findCenterPromotions(Center centerPassed);
}

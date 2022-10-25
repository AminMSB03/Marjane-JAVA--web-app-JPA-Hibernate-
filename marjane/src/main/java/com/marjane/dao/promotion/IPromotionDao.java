package com.marjane.dao.promotion;

import com.marjane.entities.Promotion;

import java.util.List;

public interface IPromotionDao {
    public void save(Promotion promotion);
    public List<Promotion> findAll();
    public List<Promotion> findByDate();
    public void update(Promotion promotion);
}

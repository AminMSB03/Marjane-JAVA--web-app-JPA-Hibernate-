package com.marjane.dao.promotion;

import com.marjane.module.*;
import com.speedment.jpastreamer.application.JPAStreamer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.stream.Collectors;

public class PromotionDaoImpl implements IPromotionDao{

    private EntityManager entityManager;

    public PromotionDaoImpl(){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("connect");

        this.entityManager = entityManagerFactory.createEntityManager();
    }



    @Override
    public void save(Promotion promotion) {

        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        try{

            this.entityManager.persist(promotion);
            transaction.commit();

        }catch (Exception exception){

            transaction.rollback();
            exception.printStackTrace();

        }
    }

    @Override
    public List<Promotion> findAll() {
        JPAStreamer jpaStreamer = JPAStreamer.of("connect");
        return jpaStreamer.stream(Promotion.class)
                .collect(Collectors.toList());
    }

    @Override
    public List<Promotion> findCenterPromotions(Center centerPassed){
        List<Promotion> promotionList = this.findAll();
        List<Promotion> promotions2 = promotionList.stream().filter(el->{
            return el.getCenter().getId()==centerPassed.getId();
        }).collect(Collectors.toList());
        return promotions2;
    }

    @Override
    public List<Promotion> findByDate() {
        return null;
    }

    @Override
    public void update(Long idPromotion,int status, String desc) {
        this.entityManager.getTransaction().begin();

        Promotion promotion = this.entityManager.find(Promotion.class, idPromotion);
        promotion.setStatus(status);
        promotion.setDescription(desc);


        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }
}

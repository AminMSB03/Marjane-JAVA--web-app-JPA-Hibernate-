package com.marjane.dao.promotion;

import com.marjane.entities.Promotion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

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
        return null;
    }

    @Override
    public List<Promotion> findByDate() {
        return null;
    }

    @Override
    public void update(Promotion promotion) {

    }
}

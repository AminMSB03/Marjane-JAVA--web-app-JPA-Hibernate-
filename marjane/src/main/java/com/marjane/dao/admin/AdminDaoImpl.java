package com.marjane.dao.admin;

import com.marjane.entities.Admin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class AdminDaoImpl implements IAdminDao{

    // declaration of EntityManager that allows to manage the entities
    private EntityManager entityManager;

    public AdminDaoImpl() {

        // Create Entity manager factory object
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("connect");

        // Create Entity manager object
        this.entityManager = entityManagerFactory.createEntityManager();
    }


    @Override
    public void save(Admin admin) {
        // Create a transaction
        EntityTransaction transaction = this.entityManager.getTransaction();

        // start transaction
        transaction.begin();
        try{
            // register the admin on tha DB
            entityManager.persist(admin);

            // validate the transaction
            transaction.commit();

        }catch (Exception exception){
            // cancel  the transaction in case of transaction
            transaction.rollback();
            exception.printStackTrace();
        }


    }

    @Override
    public List<Admin> findAll(Admin admin) {
        return null;
    }
}

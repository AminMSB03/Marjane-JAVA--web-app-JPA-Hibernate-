package com.marjane.dao.admin;

import com.marjane.module.Admin;
import com.marjane.module.Admin$;
import com.speedment.jpastreamer.application.JPAStreamer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<Admin> findAll() {
        JPAStreamer jpaStreamer = JPAStreamer.of("connect");
        return jpaStreamer.stream(Admin.class)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Admin> getAdminByEmail(String email) {

        JPAStreamer jpaStreamer =JPAStreamer.of("connect");
        Optional<Admin> adminGen =  jpaStreamer.stream(Admin.class)
                .filter(Admin$.email.equal(email))
                .findAny();

        return adminGen;
    }
    @Override
    public Optional<Admin> getAdminById(Long id) {

        JPAStreamer jpaStreamer =JPAStreamer.of("connect");
        Optional<Admin> adminGen =  jpaStreamer.stream(Admin.class)
                .filter(Admin$.id.equal(id))
                .findAny();

        return adminGen;
    }
}

package com.marjane.dao.chefRayon;


import com.marjane.module.ChefRayon;
import com.marjane.module.ChefRayon$;
import com.speedment.jpastreamer.application.JPAStreamer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ChefRayonDaoImp implements IChefRayonDao {

    private EntityManager entityManager;

    public ChefRayonDaoImp() {

        // Create Entity manager factory object
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("connect");

        // Create Entity manager object
        this.entityManager = entityManagerFactory.createEntityManager();
    }


    @Override
    public void save(ChefRayon chefRayon) {
        // Create a transaction
        EntityTransaction transaction = this.entityManager.getTransaction();

        // start transaction
        transaction.begin();
        try {
            // register the admin on tha DB
            entityManager.persist(chefRayon);

            // validate the transaction
            transaction.commit();

        } catch (Exception exception) {
            // cancel  the transaction in case of transaction
            transaction.rollback();
            exception.printStackTrace();
        }
    }

    @Override
    public Optional<ChefRayon> getAdminByEmail(String email) {

        JPAStreamer jpaStreamer =JPAStreamer.of("connect");
        Optional<ChefRayon> chefRayon =  jpaStreamer.stream(ChefRayon.class)
                .filter(ChefRayon$.email.equal(email))
                .findAny();

        return chefRayon;
    }

    @Override
    public List<ChefRayon> findAll() {
        JPAStreamer jpaStreamer = JPAStreamer.of("connect");
        return jpaStreamer.stream(ChefRayon.class)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ChefRayon> getChefById(Long id) {

        JPAStreamer jpaStreamer =JPAStreamer.of("connect");
        Optional<ChefRayon> chef =  jpaStreamer.stream(ChefRayon.class)
                .filter(ChefRayon$.id.equal(id))
                .findAny();

        return chef;
    }

}

package com.marjane.dao.adminGen;

import com.marjane.module.AdminGen;
import com.marjane.module.AdminGen$;
import com.speedment.jpastreamer.application.JPAStreamer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Optional;

public class AdminGenDaoImpl implements IAdminGenDao{


    private EntityManager entityManager;

    public AdminGenDaoImpl() {

        // Create Entity manager factory object
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("connect");

        // Create Entity manager object
        this.entityManager = entityManagerFactory.createEntityManager();
    }


    @Override
    public Optional<AdminGen> getAdminByEmail(String email) {

        JPAStreamer jpaStreamer =JPAStreamer.of("connect");
        Optional<AdminGen> adminGen =  jpaStreamer.stream(AdminGen.class)
                .filter(AdminGen$.email.equal(email))
                .findAny();

        return adminGen;
    }

    @Override
    public void save(AdminGen adminGen) {
        // Create a transaction
        EntityTransaction transaction = this.entityManager.getTransaction();

        // start transaction
        transaction.begin();
        try{
            // register the admin on tha DB
            entityManager.persist(adminGen);

            // validate the transaction
            transaction.commit();

        }catch (Exception exception){
            // cancel  the transaction in case of transaction
            transaction.rollback();
            exception.printStackTrace();
        }
    }
}

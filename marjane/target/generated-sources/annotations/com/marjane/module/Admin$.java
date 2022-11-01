package com.marjane.module;

import com.speedment.jpastreamer.field.LongField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

import java.util.List;

/**
 * The generated base for entity {@link Admin} representing entities of the
 * {@code admin}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class Admin$ {
    
    /**
     * This Field corresponds to the {@link Admin} field "id".
     */
    public static final LongField<Admin> id = LongField.create(
        Admin.class,
        "id",
        Admin::getId,
        false
    );
    /**
     * This Field corresponds to the {@link Admin} field "password".
     */
    public static final StringField<Admin> password = StringField.create(
        Admin.class,
        "password",
        Admin::getPassword,
        false
    );
    /**
     * This Field corresponds to the {@link Admin} field "adminGen".
     */
    public static final ReferenceField<Admin, AdminGen> adminGen = ReferenceField.create(
        Admin.class,
        "adminGen",
        Admin::getAdminGen,
        false
    );
    /**
     * This Field corresponds to the {@link Admin} field "center".
     */
    public static final ReferenceField<Admin, Center> center = ReferenceField.create(
        Admin.class,
        "center",
        Admin::getCenter,
        false
    );
    /**
     * This Field corresponds to the {@link Admin} field "chefRayonList".
     */
    public static final ReferenceField<Admin, List<ChefRayon>> chefRayonList = ReferenceField.create(
        Admin.class,
        "chefRayonList",
        Admin::getChefRayonList,
        false
    );
    /**
     * This Field corresponds to the {@link Admin} field "email".
     */
    public static final StringField<Admin> email = StringField.create(
        Admin.class,
        "email",
        Admin::getEmail,
        false
    );
}
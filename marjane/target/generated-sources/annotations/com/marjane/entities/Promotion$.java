package com.marjane.entities;

import com.speedment.jpastreamer.field.ComparableField;
import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.LongField;
import com.speedment.jpastreamer.field.ReferenceField;

import java.util.Date;

/**
 * The generated base for entity {@link Promotion} representing entities of the
 * {@code promotion}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class Promotion$ {
    
    /**
     * This Field corresponds to the {@link Promotion} field "id".
     */
    public static final LongField<Promotion> id = LongField.create(
        Promotion.class,
        "id",
        Promotion::getId,
        false
    );
    /**
     * This Field corresponds to the {@link Promotion} field "date".
     */
    public static final ComparableField<Promotion, Date> date = ComparableField.create(
        Promotion.class,
        "date",
        Promotion::getDate,
        false
    );
    /**
     * This Field corresponds to the {@link Promotion} field "category".
     */
    public static final ReferenceField<Promotion, Category> category = ReferenceField.create(
        Promotion.class,
        "category",
        Promotion::getCategory,
        false
    );
    /**
     * This Field corresponds to the {@link Promotion} field "promo".
     */
    public static final ComparableField<Promotion, Double> promo = ComparableField.create(
        Promotion.class,
        "promo",
        Promotion::getPromo,
        false
    );
    /**
     * This Field corresponds to the {@link Promotion} field "center".
     */
    public static final ReferenceField<Promotion, Center> center = ReferenceField.create(
        Promotion.class,
        "center",
        Promotion::getCenter,
        false
    );
    /**
     * This Field corresponds to the {@link Promotion} field "status".
     */
    public static final IntField<Promotion> status = IntField.create(
        Promotion.class,
        "status",
        Promotion::getStatus,
        false
    );
}
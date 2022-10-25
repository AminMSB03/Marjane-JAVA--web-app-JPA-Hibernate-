package com.marjane.dao.category;


import com.marjane.entities.Category;
import com.marjane.entities.Category$;
import com.speedment.jpastreamer.application.JPAStreamer;

import java.util.Optional;

public class CategoryDaoImp implements ICategoryDao{


    @Override
    public Optional<Category> find(Long id) {
        JPAStreamer jpaStreamer =JPAStreamer.of("connect");
        Optional<Category> category =  jpaStreamer.stream(Category.class)
                .filter(Category$.id.equal(id))
                .findAny();
        return category;
    }
}

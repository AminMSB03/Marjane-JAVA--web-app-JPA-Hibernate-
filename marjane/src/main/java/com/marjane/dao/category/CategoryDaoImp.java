package com.marjane.dao.category;


import com.marjane.module.Category;
import com.marjane.module.Category$;
import com.speedment.jpastreamer.application.JPAStreamer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryDaoImp implements ICategoryDao{


    @Override
    public Optional<Category> find(Long id) {
        JPAStreamer jpaStreamer =JPAStreamer.of("connect");
        Optional<Category> category =  jpaStreamer.stream(Category.class)
                .filter(Category$.id.equal(id))
                .findAny();
        return category;
    }

    @Override
    public List<Category> getCategories() {
        JPAStreamer jpaStreamer = JPAStreamer.of("connect");
        List<Category> categoriesList = jpaStreamer.stream(Category.class).collect(Collectors.toCollection(ArrayList::new));
        jpaStreamer.close();
        return categoriesList;
    }

}

package com.marjane.dao.category;

import com.marjane.module.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryDao {
    public Optional<Category> find(Long id);



    public List<Category> getCategories();
}

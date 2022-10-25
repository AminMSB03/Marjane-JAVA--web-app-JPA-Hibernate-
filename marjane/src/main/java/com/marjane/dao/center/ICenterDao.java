package com.marjane.dao.category;

import com.marjane.entities.Category;

import java.util.Optional;

public interface ICategoryDao {
    public Optional<Category> find(Long id);
}

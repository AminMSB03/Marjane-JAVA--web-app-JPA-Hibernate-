package com.marjane.dao.center;

import com.marjane.entities.Category;
import com.marjane.entities.Center;

import java.util.Optional;

public interface ICenterDao {
    public Optional<Center> find(Long id);
}

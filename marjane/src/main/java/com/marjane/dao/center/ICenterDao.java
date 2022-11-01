package com.marjane.dao.center;

import com.marjane.module.Center;

import java.util.List;
import java.util.Optional;

public interface ICenterDao {
    public Optional<Center> find(Long id);

    public List<Center> getCenterList();
}

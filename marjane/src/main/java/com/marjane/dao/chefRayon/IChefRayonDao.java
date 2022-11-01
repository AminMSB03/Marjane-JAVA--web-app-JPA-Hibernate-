package com.marjane.dao.chefRayon;

import com.marjane.module.ChefRayon;

import java.util.List;
import java.util.Optional;

public interface IChefRayonDao {
    public void save(ChefRayon chefRayon);

    public Optional<ChefRayon> getAdminByEmail(String email);

    public List<ChefRayon> findAll();

    public Optional<ChefRayon> getChefById(Long id);

}


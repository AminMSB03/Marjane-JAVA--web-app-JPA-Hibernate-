package com.marjane.dao.center;


import com.marjane.entities.Category;
import com.marjane.entities.Category$;
import com.marjane.entities.Center;
import com.marjane.entities.Center$;
import com.speedment.jpastreamer.application.JPAStreamer;

import java.util.Optional;

public class CenterDaoImp implements ICenterDao {


    @Override
    public Optional<Center> find(Long id) {
        JPAStreamer jpaStreamer =JPAStreamer.of("connect");
        Optional<Center> center =  jpaStreamer.stream(Center.class)
                .filter(Center$.id.equal(id))
                .findAny();
        return center;
    }
}

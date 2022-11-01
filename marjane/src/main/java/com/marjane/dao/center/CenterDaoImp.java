package com.marjane.dao.center;


import com.marjane.module.Center;
import com.marjane.module.Center$;
import com.speedment.jpastreamer.application.JPAStreamer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CenterDaoImp implements ICenterDao {


    @Override
    public Optional<Center> find(Long id) {
        JPAStreamer jpaStreamer =JPAStreamer.of("connect");
        Optional<Center> center =  jpaStreamer.stream(Center.class)
                .filter(Center$.id.equal(id))
                .findFirst();
        jpaStreamer.close();
        return center;
    }

    @Override
    public List<Center> getCenterList() {
        JPAStreamer jpaStreamer = JPAStreamer.of("connect");
        List<Center> centerList = jpaStreamer.stream(Center.class).collect(Collectors.toCollection(ArrayList::new));
        jpaStreamer.close();
        return centerList;
    }


}

package com.marjane.business.chefrayon;

import com.marjane.dao.admin.AdminDaoImpl;
import com.marjane.dao.admin.IAdminDao;
import com.marjane.dao.adminGen.AdminGenDaoImpl;
import com.marjane.dao.adminGen.IAdminGenDao;
import com.marjane.dao.chefRayon.ChefRayonDaoImp;
import com.marjane.dao.chefRayon.IChefRayonDao;
import com.marjane.dao.promotion.PromotionDaoImpl;
import com.marjane.module.Admin;
import com.marjane.module.AdminGen;
import com.marjane.helpers.Encryptor;
import com.marjane.module.ChefRayon;
import com.marjane.module.Promotion;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ChefRayonBusImpl implements IChefRayonBus {

    @Override
    public void addAdmin(String email, String password) throws Exception {
        Admin admin = new Admin();
        admin.setEmail(email);

        String hashedPassword = Encryptor.encryptPassword(password);

        admin.setPassword(hashedPassword);
        AdminDaoImpl adminDao = new AdminDaoImpl();
        adminDao.save(admin);
    }

    // Login for the admin General
    @Override
    public Long Login(String email, String password) throws Exception {
        IChefRayonDao chefRayonDao = new ChefRayonDaoImp();
        Optional<ChefRayon> chefRayon;
        chefRayon = chefRayonDao.getAdminByEmail(email);
        if(chefRayon.isPresent() ){
            ChefRayon chefRayon1 = chefRayon.get();
            if(Encryptor.checkPassword(password,chefRayon1.getPassword())) return chefRayon1.getId();
        }
        return null;
    }


    // Get all admins of Marjane center's
    @Override
    public List<Admin> getAllAdmins() {
        IAdminDao adminDao = new AdminDaoImpl();
        List<Admin> adminList= adminDao.findAll();
        return adminList;
    }

    // To add a general admin
    @Override
    public void addAdminGen(String email, String password) throws Exception {
        AdminGen adminGen = new AdminGen();
        adminGen.setEmail(email);

        String hashedPassword = Encryptor.encryptPassword(password);

        adminGen.setPassword(hashedPassword);
        IAdminGenDao adminDao = new AdminGenDaoImpl();
        adminDao.save(adminGen);
    }

    @Override
    public List<Promotion> getPromotions(Long idChef) throws Exception {
        ChefRayon chefRayon = null;
        ChefRayonDaoImp chefRayonDaoImp = new ChefRayonDaoImp();
        Optional<ChefRayon> chefRayon1 = chefRayonDaoImp.getChefById(idChef);
        if(chefRayon1.isPresent()){
            chefRayon = chefRayon1.get();
        }

        LocalDate date = LocalDate.now();
        Date nowDate =Date.valueOf(date);

        PromotionDaoImpl promotionDao = new PromotionDaoImpl();
        ChefRayon finalChefRayon = chefRayon;
        return  promotionDao.findCenterPromotions(chefRayon.getCenter()).stream().filter(el->{
            return el.getCategory().getId() == finalChefRayon.getCategory().getId();
        }).filter(el->{
            if(el.getEndDate().compareTo(nowDate)>=0){
                return true;
            }else{
                return false;
            }
        }).collect(Collectors.toList());
    }

    @Override
    public void actOnPromo(Long idPromotion, int status, String desc) {
        PromotionDaoImpl promotionDao = new PromotionDaoImpl();
        promotionDao.update(idPromotion,status, desc);
    }


}

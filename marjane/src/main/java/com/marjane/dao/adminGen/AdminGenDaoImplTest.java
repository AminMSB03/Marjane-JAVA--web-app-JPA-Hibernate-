package com.marjane.dao.adminGen;

import com.marjane.module.AdminGen;
import com.marjane.helpers.Encryptor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AdminGenDaoImplTest {

    @Test
    void getAdminByEmail() throws Exception {
        AdminGenDaoImpl adminGenDao = new AdminGenDaoImpl();
        AdminGen adminGen = new AdminGen();
        adminGen.setAdminId(1);
        adminGen.setEmail("adminGen@gmail.com");
        Encryptor encryptor = new Encryptor();
        String password = encryptor.encryptPassword("adminGen123");
        adminGen.setPassword(password);
        adminGen.setAdminList(Arrays.asList());
        Optional<AdminGen> adminGenOptional = Optional.of(adminGen);
        assertEquals(adminGenOptional,adminGenDao.getAdminByEmail("adminGen@gmail.com"));
    }
}
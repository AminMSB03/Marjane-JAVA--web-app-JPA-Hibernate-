package com.marjane.helpers;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Encryptor {


    static public String encryptPassword(String password) throws Exception{

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md. digest(password.getBytes());
        BigInteger bigInt = new BigInteger( 1, messageDigest) ;

        return bigInt.toString( 16);
    }

    static public Boolean checkPassword(String password, String hashPassword) throws Exception {
        String passwordToCheck = Encryptor.encryptPassword(password);
        if(passwordToCheck.equals(hashPassword)){
            return true;
        }
        return false;
    }

}

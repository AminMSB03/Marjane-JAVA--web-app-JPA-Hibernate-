package com.marjane.presentation;


import com.marjane.business.adminGen.AdminGenBusImpl;

public class Main {
    public static void main(String[] args) throws Exception {
        AdminGenBusImpl adminGenBus = new AdminGenBusImpl();
        Boolean result = adminGenBus.Login("adminGen@gmail.com","adminGen123");
        System.out.println(result);



    }
}

package com.marjane.presentation;


import com.marjane.business.adminGen.AdminGenBusImpl;

public class Main {
    public static void main(String[] args) throws Exception {
        AdminGenBusImpl adminBus = new AdminGenBusImpl();
        adminBus.addAdmin("amine@amine.com","amine123");
    }
}

package com.marjane.business.adminGen;

public interface IAdminGenBus {
    public void addAdmin(String email, String password);

    public Boolean Login(String email, String password);
}

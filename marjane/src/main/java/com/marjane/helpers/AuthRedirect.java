package com.marjane.helpers;

import com.marjane.business.admin.AdminBusImp;
import com.marjane.business.adminGen.AdminGenBusImpl;
import com.marjane.business.chefrayon.ChefRayonBusImpl;
import com.marjane.dao.chefRayon.ChefRayonDaoImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthRedirect {

    static public void AdminGen(String email, String password, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean result = false;

        AdminGenBusImpl adminGenBus = new AdminGenBusImpl();
        try {
            result = adminGenBus.Login(email,password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(result){
            resp.sendRedirect("statistics");
        }else {
            resp.sendRedirect("login");
        }
    }


    static public void Admin(String email, String password,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long result = null;

        AdminBusImp adminBusImp = new AdminBusImp();

        try {
            result = adminBusImp.Login(email,password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(result!=null){
            HttpSession session = req.getSession();
            session.setAttribute("AdminID",result);
            resp.sendRedirect("adminDashboardHome");
        }else {
            resp.sendRedirect("login");
        }
    }


    static public void Chef(String email,String password, HttpServletRequest req,HttpServletResponse resp) throws IOException {

        Long result = null;

        ChefRayonBusImpl chefRayonBus = new ChefRayonBusImpl();

        try{
            result = chefRayonBus.Login(email,password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(result!=null){
            HttpSession session = req.getSession();
            session.setAttribute("ChefID",result);
            resp.sendRedirect("chef_dashboard");
        }else {
            resp.sendRedirect("login");
        }

    }

}

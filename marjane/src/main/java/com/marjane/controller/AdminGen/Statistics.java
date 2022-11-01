package com.marjane.controller.AdminGen;

import com.marjane.business.adminGen.AdminGenBusImpl;
import com.marjane.business.adminGen.IAdminGenBus;
import com.marjane.module.Admin;
import com.marjane.module.Center;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/statistics")
public class Statistics extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IAdminGenBus adminGenBus = new AdminGenBusImpl();
        List<Admin> adminList = adminGenBus.getAllAdmins();
        List<Center> centerList = adminGenBus.getAllCenters();

        req.setAttribute("admins", adminList);
        req.setAttribute("centers",centerList);
        req.getRequestDispatcher("/views/adminGen/statistics.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IAdminGenBus adminGenBus = new AdminGenBusImpl();
        List<Admin> adminList = adminGenBus.getAllAdmins();
        List<Center> centerList = adminGenBus.getAllCenters();

        req.setAttribute("admins", adminList);
        req.setAttribute("centers",centerList);
        req.getRequestDispatcher("/views/adminGen/statistics.jsp").forward(req,resp);
    }
}

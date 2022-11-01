package com.marjane.controller.Admin;

import com.marjane.business.admin.AdminBusImp;
import com.marjane.business.admin.IAdminBus;
import com.marjane.module.Category;
import com.marjane.module.ChefRayon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminDashboardHome")
public class Home extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IAdminBus adminBus = new AdminBusImp();
        List<ChefRayon> chefRayonList = adminBus.getAllChefs();
        List<Category> categories = adminBus.getCategories();

        req.setAttribute("chefs", chefRayonList);
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/views/admin/homeDashboard.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IAdminBus adminBus = new AdminBusImp();
        List<ChefRayon> chefRayonList = adminBus.getAllChefs();
        List<Category> categories = adminBus.getCategories();

        req.setAttribute("chefs", chefRayonList);
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/views/admin/homeDashboard.jsp").forward(req,resp);
    }
}

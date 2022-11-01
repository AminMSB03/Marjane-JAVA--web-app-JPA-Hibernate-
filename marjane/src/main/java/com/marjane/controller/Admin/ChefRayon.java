package com.marjane.controller.Admin;

import com.marjane.business.admin.AdminBusImp;
import com.marjane.business.admin.IAdminBus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/chefRayon/*")
public class ChefRayon extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String chefEmail = req.getParameter("email");
        String chefPassword = req.getParameter("password");
        long categoryId = Long.valueOf(req.getParameter("category"));


        HttpSession session=req.getSession(false);
        Long idAdmin=(Long)session.getAttribute("AdminID");

        System.out.println(chefEmail);
        System.out.println(chefPassword);
        System.out.println(categoryId);
        System.out.println(idAdmin);



        IAdminBus adminBus = new AdminBusImp();
        try {
            adminBus.addChefRayon(chefEmail,chefPassword,categoryId,idAdmin);
            resp.sendRedirect("adminDashboardHome");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}

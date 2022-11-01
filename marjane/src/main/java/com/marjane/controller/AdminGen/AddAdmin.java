package com.marjane.controller.AdminGen;


import com.marjane.business.adminGen.AdminGenBusImpl;
import com.marjane.business.adminGen.IAdminGenBus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dashboard")
public class AddAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminEmail = req.getParameter("email");
        String adminPassword = req.getParameter("password");
        long centerId = Long.valueOf(req.getParameter("center"));

        IAdminGenBus adminGenBus = new AdminGenBusImpl();
        try {
            adminGenBus.addAdmin(adminEmail,adminPassword,centerId);
            /*RequestDispatcher dispatcher = req.getServletContext()
                    .getRequestDispatcher("/adminDashboardHome");
            dispatcher.forward(req, resp);
             */
            resp.sendRedirect("statistics");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

package com.marjane.controller.Chef;

import com.marjane.business.chefrayon.ChefRayonBusImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/action")
public class Promo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idPromo = req.getParameter("promoId");
        String action = req.getParameter("action");
        String comment = req.getParameter("comment");

        ChefRayonBusImpl chefRayonBus = new ChefRayonBusImpl();
        chefRayonBus.actOnPromo(Long.valueOf(idPromo),Integer.valueOf(action),comment);

        resp.sendRedirect("chef_dashboard");
    }
}

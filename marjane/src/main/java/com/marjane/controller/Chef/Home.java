package com.marjane.controller.Chef;

import com.marjane.business.chefrayon.ChefRayonBusImpl;
import com.marjane.module.Promotion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/chef_dashboard")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession(false);
        Long idChef = (Long) session.getAttribute("ChefID");

        ChefRayonBusImpl chefRayonBus = new ChefRayonBusImpl();
        List<Promotion> promotions;
        try {
            promotions = chefRayonBus.getPromotions(idChef);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("promotions", promotions);
        req.getRequestDispatcher("/views/chef/home.jsp").forward(req, resp);

    }
}

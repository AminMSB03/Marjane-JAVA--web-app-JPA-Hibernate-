package com.marjane.controller.Admin;

import com.marjane.business.admin.AdminBusImp;
import com.marjane.business.admin.IAdminBus;
import com.marjane.module.Category;
import com.marjane.module.Promotion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.List;

@WebServlet("/promos")
public class Promos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession(false);
        Long idAdmin=(Long)session.getAttribute("AdminID");
        IAdminBus adminBus = new AdminBusImp();
        List<Promotion> promotions = adminBus.getPromotions(idAdmin);
        List<Category> categories = adminBus.getCategories();

        //promotions.stream().forEach(val-> System.out.println(val.getId()));


        req.setAttribute("promotions", promotions);
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/views/admin/promos.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String start = req.getParameter("start");
        String end = req.getParameter("end");
        Long category = Long.valueOf(req.getParameter("category"));
        Double promo = Double.valueOf(req.getParameter("promo"));

        LocalDate date = LocalDate.parse(start);
        Date startDate =Date.valueOf(date);

        LocalDate date2 = LocalDate.parse(end);
        Date endDate =Date.valueOf(date2);


        HttpSession session=req.getSession(false);
        Long idAdmin=(Long)session.getAttribute("AdminID");

        AdminBusImp adminBusImp = new AdminBusImp();
        adminBusImp.addPromotion(category,idAdmin,promo,startDate,endDate);



        resp.sendRedirect("promos");

    }
}

package com.marjane.controller.authentification;

import com.marjane.helpers.AuthRedirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Dashboard")
public class RoleChecker extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pos = req.getParameter("position");
        String email = req.getParameter("email");
        String password  = req.getParameter("password");


        req.setAttribute("email", email);
        req.setAttribute("password", password);
        RequestDispatcher rd;
        switch (pos){
            case "adminGen":
                 AuthRedirect.AdminGen(email,password,req,resp);
                 break;
            case "admin":
                AuthRedirect.Admin(email,password,req,resp);
                break;
            case "chef":
                AuthRedirect.Chef(email,password,req,resp);
                break;
            default:
                rd = req.getRequestDispatcher("Login");
                rd.forward(req,resp);

        }

    }
}

package com.codecool.web.servlet;


import com.codecool.web.DAO.AssigmentDAO;
import com.codecool.web.model.user.User;
import com.codecool.web.service.UserDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        String name = request.getParameter("fullname");
        String mail = request.getParameter("mail");
        String role = request.getParameter("role");
        String password = request.getParameter("password");


        UserDaoImpl userDao = UserDaoImpl.getInstance();
        userDao.updateUser(new User(name, mail, role, password));

        if (name.isEmpty() || mail.isEmpty() || role.isEmpty() || password.isEmpty()) {

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            out.println("<font color=red>Please fill all the fields</font>");
            rd.include(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
        }
    }
}


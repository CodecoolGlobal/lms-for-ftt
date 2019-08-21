package com.codecool.web.servlet;

import com.codecool.web.DAO.DBUserDao;
import com.codecool.web.model.enums.Role;
import com.codecool.web.model.user.User;
import com.codecool.web.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends AbstractServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection connection = getConnection(request.getServletContext())){
            DBUserDao userDao = new DBUserDao(connection);
            UserService us = new UserService(userDao);

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            String name = request.getParameter("user_name");
            String mail = request.getParameter("email");
            HttpSession session = request.getSession(false);
            session.setAttribute("email", mail);
            mail = (String) session.getAttribute("email");
            String role = request.getParameter("role");
            String password = request.getParameter("password");
            
            if (us.notValidated(name, mail, role, password).equals("newUser")) {
                User user = null;
                us.addUser(name, mail, role, password);
                user = us.getUser(mail);
                session.setAttribute("user", user);
    
                //request.setAttribute("user", user);
    
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);
            } else if(us.notValidated(name, mail, role, password).equals("empty")) {
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                out.println("<font color=red>Please fill in each field</font>");
                rd.include(request, response);
                
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}


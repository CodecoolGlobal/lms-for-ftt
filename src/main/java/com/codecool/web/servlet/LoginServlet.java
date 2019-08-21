package com.codecool.web.servlet;

import com.codecool.web.DAO.DBUserDao;
import com.codecool.web.model.user.User;
import com.codecool.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends AbstractServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try (Connection connection = getConnection(request.getServletContext())){
            DBUserDao userDao = new DBUserDao(connection);
            UserService us = new UserService(userDao);
            
            String email = request.getParameter("email");
            String password = request.getParameter("password");
    
            if(us.login(email, password)){
                User user = us.getUser(email);
                request.getSession().setAttribute("user", user);
                response.sendRedirect("protected/profil.jsp");
            }else {
                request.setAttribute("error", "Incorrect login");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

}

package com.codecool.web.servlet;

import com.codecool.web.model.user.User;
import com.codecool.web.service.LoginService;
import com.codecool.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends AbstractServlet {

    /*@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        UserService userService = (UserService) request.getServletContext().getAttribute("userService");
        LoginService loginService = (LoginService) request.getServletContext().getAttribute("loginService");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        List<User> users =userService.getUsers();

        if(loginService.login(email, password)){
            User user = userService.getUser(email);
            request.getSession().setAttribute("user", user);
            response.sendRedirect("protected/profil.jsp");
        }else {
            request.setAttribute("error", "Incorrect login");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }*/
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

}

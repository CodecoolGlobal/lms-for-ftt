package com.codecool.web.servlet;

import com.codecool.web.model.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/protected/profile")
public class ProfilServlet extends HttpServlet {

    /*
         * Users after successful login are redirected to the /protected/profile resource. Being redirected there
         * will invoke this method.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("user", user);
        req.getRequestDispatcher("profil.jsp").forward(req, resp);
    }
}

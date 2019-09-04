package com.codecool.web.servlet;

import com.codecool.web.DAO.DBUserDao;
import com.codecool.web.model.user.User;
import com.codecool.web.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


@WebServlet("/protected/editPassword")
public class PasswordModifyServlet extends AbstractServlet {


    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(Connection connection = getConnection(request.getServletContext()) ) {
            DBUserDao dbUserDao = new DBUserDao(connection);
            UserService userService = new UserService(dbUserDao);
            User user = getCurrentUser(request);
            String newPassword = request.getParameter("passw");
            user.setPassword(newPassword);
            userService.modifyPassword(user.getUserId(), newPassword);
            request.getRequestDispatcher("profil.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }*/

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("profil.jsp").forward(request, response);
    }

    private User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (User) session.getAttribute("user");
    }
}

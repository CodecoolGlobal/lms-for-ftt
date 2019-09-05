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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/protected/userlist")
public class UserListServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        try (Connection connection = getConnection(request.getServletContext())) {
            DBUserDao userDao = new DBUserDao(connection);
            UserService userService = new UserService(userDao);
            request.setAttribute("userList", userService.getUsers());

        } catch (SQLException e) {
            e.getMessage();
        }
        request.getRequestDispatcher("userList.jsp").forward(request, response);
    }
}

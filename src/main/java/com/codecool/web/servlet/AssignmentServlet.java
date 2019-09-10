package com.codecool.web.servlet;

import com.codecool.web.DAO.DBAssignmentDao;
import com.codecool.web.model.user.User;
import com.codecool.web.service.AssignmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/protected/post-assignment")
public class AssignmentServlet extends AbstractServlet {
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = getConnection(req.getServletContext())){
            DBAssignmentDao asDao = new DBAssignmentDao(conn);
            AssignmentService asService = new AssignmentService(asDao);
            HttpSession session = req.getSession(false);
            User user = (User) session.getAttribute("user");
            String id = req.getParameter("id");
            
            req.setAttribute("assignment", asService.getById(conn, Integer.parseInt(id)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        req.getRequestDispatcher("add-solution.jsp").forward(req, resp);
    }
}

package com.codecool.web.servlet;

import com.codecool.web.DAO.DBAssignmentDao;
import com.codecool.web.model.curriculum.Assignment;
import com.codecool.web.model.user.User;
import com.codecool.web.service.AssignmentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public class AddAssignment extends AbstractServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");
        
        
        try (Connection connection = getConnection(req.getServletContext())){
            DBAssignmentDao assignmentDao = new DBAssignmentDao(connection);
            AssignmentService assignmentService = new AssignmentService(assignmentDao);
    
    
            HttpSession session = req.getSession(false);
            User user = (User) session.getAttribute("user");
    
            if (req.getParameter("question") != null) {
                String title = req.getParameter("title");
                String question = req.getParameter("question");
                int maxScore = Integer.getInteger("max_Score");
                Boolean isPublished = Boolean.getBoolean(req.getParameter("is_published"));
    
                Assignment assignment = new Assignment(title, question, isPublished, maxScore);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

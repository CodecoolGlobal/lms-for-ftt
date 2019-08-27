package com.codecool.web.servlet;

import com.codecool.web.DAO.DBAssignmentDao;
import com.codecool.web.model.curriculum.Assignment;
import com.codecool.web.model.user.User;
import com.codecool.web.service.AssignmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;


@WebServlet("/protected/add-assignment")
public class AddAssignmentServlet extends AbstractServlet {
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
                int maxScore = Integer.parseInt(req.getParameter("max_score"));
                Boolean isPublished = Boolean.getBoolean(req.getParameter("is_published"));
            
                Assignment assignment = new Assignment(title, question, isPublished, maxScore);
                assignmentService.addAssignment(assignment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

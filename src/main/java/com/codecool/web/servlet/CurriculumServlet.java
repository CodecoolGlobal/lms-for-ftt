package com.codecool.web.servlet;


import com.codecool.web.DAO.DBAssignmentDao;
import com.codecool.web.DAO.DBTextDao;
import com.codecool.web.model.curriculum.Assignment;
import com.codecool.web.model.curriculum.Text;
import com.codecool.web.model.enums.Role;
import com.codecool.web.model.user.User;
import com.codecool.web.service.AssignmentService;
import com.codecool.web.service.TextService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/protected/curriculum")
public class CurriculumServlet extends AbstractServlet {
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");
        
        
        try (Connection connection = getConnection(req.getServletContext())){
            DBTextDao textDao = new DBTextDao(connection);
            TextService textService = new TextService(textDao);
    
            DBAssignmentDao assignmentDao = new DBAssignmentDao(connection);
            AssignmentService assignmentService = new AssignmentService(assignmentDao);
            
            HttpSession session = req.getSession(false);
            User user = (User) session.getAttribute("user");
            
            List<Text> texts = textService.getAllText();
            req.setAttribute("texts", texts);
    
            List<Assignment> assignments = assignmentService.getAllAssignments();
            req.setAttribute("assignments", assignments);
            
            if (user.getRole().equals(Role.MENTOR)) {
                req.getRequestDispatcher("curriculum-mentor.jsp").forward(req, resp);
            } else if (user.getRole().equals(Role.STUDENT)){
                req.getRequestDispatcher("curriculum-student.jsp").forward(req, resp);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

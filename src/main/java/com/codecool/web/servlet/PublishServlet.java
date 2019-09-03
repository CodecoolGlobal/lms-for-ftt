package com.codecool.web.servlet;

import com.codecool.web.DAO.DBAssignmentDao;
import com.codecool.web.DAO.DBTextDao;
import com.codecool.web.service.AssignmentService;
import com.codecool.web.service.TextService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/publishServlet")
public class PublishServlet extends AbstractServlet {
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = getConnection(req.getServletContext())) {
            String[] publishT = req.getParameterValues("publish_text");
            String[] publishA = req.getParameterValues("publish_assignment");
            
            DBTextDao dbTextDao = new DBTextDao(conn);
            TextService textService = new TextService(dbTextDao);
            
            DBAssignmentDao dbAssignmentDao = new DBAssignmentDao(conn);
            AssignmentService assignmentService = new AssignmentService(dbAssignmentDao);
            
            if (publishT != null) {
                textService.publishText(publishT);
            } if (publishA != null) {
                assignmentService.publishAssignment(publishA);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        req.getRequestDispatcher("curriculum").forward(req, resp);
    }
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("curriculum-mentor.jsp").forward(req, resp);
    }
}

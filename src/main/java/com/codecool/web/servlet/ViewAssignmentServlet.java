package com.codecool.web.servlet;

import com.codecool.web.DAO.DBAnswerDao;
import com.codecool.web.DAO.DBAssignmentDao;
import com.codecool.web.model.curriculum.Assignment;
import com.codecool.web.model.enums.Role;
import com.codecool.web.model.user.User;
import com.codecool.web.service.AnswerService;
import com.codecool.web.service.AssignmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/protected/view-assignment")
public class ViewAssignmentServlet extends AbstractServlet {
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");
        
        if (user.getRole().equals(Role.MENTOR)) {
            try (Connection conn = getConnection(req.getServletContext())) {
                DBAssignmentDao asDao = new DBAssignmentDao(conn);
                AssignmentService asService = new AssignmentService(asDao);
                req.setAttribute("assignments", asService.getAllAssignments());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            req.getRequestDispatcher("show-mentor-assignment.jsp").forward(req, resp);
            
        } else if (user.getRole().equals(Role.STUDENT)) {
            List<Assignment> publishedAs = new ArrayList<>();
            try (Connection conn = getConnection(req.getServletContext())) {
                DBAssignmentDao asDao = new DBAssignmentDao(conn);
                AssignmentService asService = new AssignmentService(asDao);
    
                DBAnswerDao answerDao = new DBAnswerDao(conn);
                AnswerService answerService = new AnswerService(answerDao);
                
                for (Assignment as : asService.getAllAssignments()) {
                    if (as.isPublished() && !answerService.isAnswered(conn, as.getId(), user.getUserId())) {
                        publishedAs.add(as);
                    }
                }
                
                req.setAttribute("assignment", publishedAs);
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
    
            req.getRequestDispatcher("show-student-assignment.jsp").forward(req, resp);
        }
    }
}

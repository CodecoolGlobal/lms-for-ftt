package com.codecool.web.servlet;

import com.codecool.web.DAO.DBAnswerDao;
import com.codecool.web.DAO.DBAssignmentDao;
import com.codecool.web.model.curriculum.Answer;
import com.codecool.web.model.curriculum.Assignment;
import com.codecool.web.model.user.User;
import com.codecool.web.service.AnswerService;
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

@WebServlet("/protected/view-answer")
public class ViewSingleAnswerServlet extends AbstractServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");
        
        try (Connection conn = getConnection(req.getServletContext())) {
            int id;
            DBAnswerDao answerDao = new DBAnswerDao(conn);
            AnswerService answerService = new AnswerService(answerDao);
            
            DBAssignmentDao asDao = new DBAssignmentDao(conn);
            AssignmentService asService = new AssignmentService(asDao);
    
            Answer tempAns = answerService.singleAnswer(conn, user);
            req.setAttribute("singleAnswer", tempAns);
            
            id = tempAns.getAssignmentID();
            
            Assignment tempAs = asService.getById(conn, id);
            
            req.setAttribute("assignment", tempAs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        req.getRequestDispatcher("view-answer.jsp").forward(req, resp);
    }
}

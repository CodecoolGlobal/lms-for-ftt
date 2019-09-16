package com.codecool.web.servlet;

import com.codecool.web.DAO.DBAnswerDao;
import com.codecool.web.DAO.DBAssignmentDao;
import com.codecool.web.model.curriculum.Solution;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/protected/view-stats")
public class StatsServlet extends AbstractServlet {
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        HttpSession session = req.getSession(false);
        User actUser = (User) session.getAttribute("user");
        
        try (Connection conn = getConnection(req.getServletContext())){
            List<Solution> solutions = new ArrayList<>();
        
            DBAnswerDao answerDao = new DBAnswerDao(conn);
            AnswerService anService = new AnswerService(answerDao);
        
            DBAssignmentDao asDao = new DBAssignmentDao(conn);
            AssignmentService asService = new AssignmentService(asDao);
        
        
        
            solutions = anService.studentSolutions(conn, actUser);
            req.setAttribute("solutions", solutions);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    
        req.getRequestDispatcher("view-statistics.jsp").forward(req, resp);
    }
}

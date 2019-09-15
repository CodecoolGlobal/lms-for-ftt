package com.codecool.web.servlet;

import com.codecool.web.DAO.DBAnswerDao;
import com.codecool.web.service.AnswerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/protected/scoring")
public class ScoringServlet extends AbstractServlet {
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try (Connection conn = getConnection(req.getServletContext())){
            
            DBAnswerDao answerDao = new DBAnswerDao(conn);
            AnswerService anService = new AnswerService(answerDao);
            HttpSession session = req.getSession(false);
    
            String id = req.getParameter("assignmentID");
            String userId = req.getParameter("userID");
    
            req.setAttribute("solution", anService.singleSolution(conn,Integer.parseInt(id), Integer.parseInt(userId)));
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    
        req.getRequestDispatcher("add-score.jsp").forward(req, resp);
    }
}

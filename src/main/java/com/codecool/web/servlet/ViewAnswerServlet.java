package com.codecool.web.servlet;

import com.codecool.web.DAO.DBAnswerDao;
import com.codecool.web.service.AnswerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/protected/view-answers")
public class ViewAnswerServlet extends AbstractServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = getConnection(req.getServletContext())) {
            String id;
            DBAnswerDao answerDao = new DBAnswerDao(conn);
            AnswerService answerService = new AnswerService(answerDao);
            
            id = req.getParameter("id");
            req.setAttribute("id", id);
            req.setAttribute("answerlist", answerService.listByAssignmentId(conn, Integer.parseInt(id)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        req.getRequestDispatcher("show-answers.jsp").forward(req, resp);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String givenScore = req.getParameter("givenscores");
        req.setAttribute("givenscores", givenScore);
    
        req.getRequestDispatcher("show-answers.jsp").forward(req, resp);
    }
}

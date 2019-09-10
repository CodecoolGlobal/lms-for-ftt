package com.codecool.web.servlet;

import com.codecool.web.DAO.DBAnswerDao;
import com.codecool.web.model.curriculum.Answer;
import com.codecool.web.model.user.User;
import com.codecool.web.service.AnswerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/protected/solution")
public class SolutionServlet extends AbstractServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        String id = req.getParameter("id");
        String tempSol = req.getParameter("solution");
        HttpSession session = req.getSession(false);
        int userId = ((User) session.getAttribute("user")).getUserId();
    
    
        try (Connection conn = getConnection(req.getServletContext())){
            
            DBAnswerDao answerDao = new DBAnswerDao(conn);
            AnswerService anService = new AnswerService(answerDao);
            
            Answer tempAns = new Answer(Integer.parseInt(id), userId, tempSol);
            
            anService.addSolution(Integer.parseInt(id), userId, tempSol , tempAns.getSubmissionDate());
            
        } catch (SQLException e) {
            throw new  ServletException(e);
        }
        
        req.setAttribute("id", id);
        
        resp.sendRedirect("view-answer");
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        String id = req.getParameter("id");
        String tempSol = req.getParameter("solution");
        HttpSession session = req.getSession(false);
        int userId = ((User) session.getAttribute("user")).getUserId();
    
    
        try (Connection conn = getConnection(req.getServletContext())){
        
            DBAnswerDao answerDao = new DBAnswerDao(conn);
            AnswerService anService = new AnswerService(answerDao);
        
            Answer tempAns = new Answer(Integer.parseInt(id), userId, tempSol);
        
            anService.addSolution(Integer.parseInt(id), userId, tempSol , tempAns.getSubmissionDate());
        
        } catch (SQLException e) {
            throw new  ServletException(e);
        }
    
        req.setAttribute("id", id);
        resp.sendRedirect("view-answer");
    }
}

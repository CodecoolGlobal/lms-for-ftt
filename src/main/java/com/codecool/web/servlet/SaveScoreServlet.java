package com.codecool.web.servlet;

import com.codecool.web.DAO.DBAnswerDao;
import com.codecool.web.model.curriculum.Solution;
import com.codecool.web.model.user.User;
import com.codecool.web.service.AnswerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/protected/save-score")
public class SaveScoreServlet extends AbstractServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = getConnection(req.getServletContext())){
            DBAnswerDao answerDao = new DBAnswerDao(conn);
            AnswerService anService = new AnswerService(answerDao);
            
            HttpSession session = req.getSession(false);
            User user = (User) session.getAttribute("user");
            String asId = req.getParameter("assignmentId");
            String usId = req.getParameter("userId");
            String score = req.getParameter("score");
            anService.setScore(conn, Integer.parseInt(asId), Integer.parseInt(usId), Integer.parseInt(score));
            
            req.setAttribute("solutions", anService.allSolutions(conn));
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        req.getRequestDispatcher("solution-list").forward(req, resp);
    }
}

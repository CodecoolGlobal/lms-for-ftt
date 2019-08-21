package com.codecool.web.servlet;


import com.codecool.web.DAO.DBTextDao;
import com.codecool.web.model.curriculum.Text;
import com.codecool.web.model.enums.Role;
import com.codecool.web.model.user.User;
import com.codecool.web.service.TextService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/curriculum")
public class CurriculumServlet extends AbstractServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())){
            DBTextDao textDao = new DBTextDao(connection);
            TextService textService = new TextService(textDao);
            
            HttpSession session = req.getSession(false);
            User user = (User) session.getAttribute("user");
            /*String title = req.getParameter("title");
            String text = req.getParameter("text");*/
            boolean isPublished = Boolean.parseBoolean(req.getParameter("isPublished"));
            
            List<Text> texts = textService.getAllText();
            req.setAttribute("texts", texts);
            
            if (user.getRole().equals(Role.MENTOR)) {
                req.getRequestDispatcher("curriculum-mentor.jsp").forward(req, resp);
            } else {
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

package com.codecool.web.servlet;

import com.codecool.web.DAO.DBTextDao;
import com.codecool.web.model.curriculum.Text;
import com.codecool.web.model.user.User;
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

@WebServlet("/protected/add-text")
public class AddTextServlet extends AbstractServlet {
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");
        
        try (Connection connection = getConnection(req.getServletContext())){
            DBTextDao dbTextDao = new DBTextDao(connection);
            TextService textService = new TextService(dbTextDao);
    
            HttpSession session = req.getSession(false);
            User user = (User) session.getAttribute("user");
    
            if (req.getParameter("text") != null) {
                String title = req.getParameter("title");
                String text = req.getParameter("text");
                Boolean isPublished = Boolean.getBoolean(req.getParameter("is_published"));
    
                Text text1 = new Text(title, text, isPublished);
                textService.addText(text1);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        resp.sendRedirect("curriculum");
        
    }
}

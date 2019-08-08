package com.codecool.web.servlet;


import com.codecool.web.model.curriculum.Text;
import com.codecool.web.service.TextService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/curriculum")
public class CurriculumServlet extends AbstractServlet {
    
    private final TextService myService = TextService.getMyInstance();
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //try {
        //HttpSession session = req.getSession(false);
        //User user = (User) session.getAttribute("user");
        String title = req.getParameter("title");
        String text = req.getParameter("text");
        boolean isPublished = Boolean.parseBoolean(req.getParameter("isPublished"));
        
        List<Text> pages = myService.getText();
        req.setAttribute("pages", pages);
        
        req.getRequestDispatcher("curriculum-mentor.jsp").forward(req, resp);
        
        //}
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

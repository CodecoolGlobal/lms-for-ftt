package com.codecool.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "AbstractServlet")
public class AbstractServlet extends HttpServlet {
    
    protected Connection getConnection(ServletContext sce) throws SQLException {
        DataSource dataSource = (DataSource) sce.getAttribute("dataSource");
        return dataSource.getConnection();
    }
}

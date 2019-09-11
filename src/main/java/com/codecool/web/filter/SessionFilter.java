package com.codecool.web.filter;

import com.codecool.web.model.user.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/protected/*")
public final class SessionFilter implements Filter {
    private ServletContext servletContext;

    @Override
    public void init(FilterConfig filterConfig){
        this.servletContext = filterConfig.getServletContext();
        System.out.println("RoleFilter initialized");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)throws IOException, ServletException{
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String contextPath = servletContext.getContextPath();
        String loginURI = contextPath+ "/login";
        String requestURI = req.getRequestURI();
        String registerURI = contextPath;
       // User user =(User) session.getAttribute("user");

        if((session != null && session.getAttribute("user") !=null)||requestURI.startsWith(contextPath+"/resources/")||
            req.getRequestURI().equals(loginURI) || req.getRequestURI().equals(registerURI)){
            filterChain.doFilter(request, response);
        }else{
            resp.sendRedirect(loginURI);
        }

        /*
        if(user == null){
            resp.sendRedirect("../login.jsp");
        } else {
            filterChain.doFilter(req, resp);
        }*/
    }

    @Override
    public  void destroy(){

    }
}

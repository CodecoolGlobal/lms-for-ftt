package com.codecool.web.listener;

import com.codecool.web.service.LoginService;
import com.codecool.web.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public final class WebappContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        UserService userService = new UserService();
        LoginService loginService = new LoginService(userService);

        ServletContext ctx = sce.getServletContext();
        ctx.setAttribute("userService", userService);
        ctx.setAttribute("loginService", loginService);
        System.out.println("This method is invoked once when the webapp gets deployed.");

        //GreetingService gs = new GreetingService();
        //sce.getServletContext().setAttribute(GreetingService.class.getName(), gs);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("This method is invoked once when the webapp gets undeployed.");
    }
}

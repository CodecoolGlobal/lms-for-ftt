package com.codecool.web.service;

import com.codecool.web.model.user.User;

import java.sql.SQLException;

public class LoginService {

    private final UserService userService;

    public LoginService(UserService userService) {
        this.userService = userService;
    }

    public boolean login(String email, String password) throws SQLException {
        for(User user : userService.getUsers()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}


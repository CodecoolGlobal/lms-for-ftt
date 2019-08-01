package com.codecool.web.service;

import com.codecool.web.model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final List<User> users;


    public UserService(){
        users = UserDaoImpl.getInstance().getUsers();
        users.add(new User("user", "user", "Student", "1234"));


    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(String mail){
        for(User user : users){
            if(user.getEmail().equals(mail)){
                return user;
            }
        }
        return null;

    }
}

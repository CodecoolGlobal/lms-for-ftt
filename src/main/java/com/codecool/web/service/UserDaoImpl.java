package com.codecool.web.service;

import com.codecool.web.DAO.AssigmentDAO;
import com.codecool.web.model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements AssigmentDAO {

    private static UserDaoImpl instance = new UserDaoImpl();


    List<User> users = new ArrayList<User>();

    public UserDaoImpl() {

        User user1 = new User("Valaki", "adam.beluscsak@gmail.com", "Student", "1234");
        users.add(user1);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }


    @Override
    public void updateUser(User user) {
        //elleőrizni van e már regisztált user
        users.add(user);

    }

    public static UserDaoImpl getInstance() {
        return instance;
    }

    public List<User> getUser(){
        return users;
    }


}

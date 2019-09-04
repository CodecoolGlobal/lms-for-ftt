package com.codecool.web.service;

import com.codecool.web.DAO.DBUserDao;
import com.codecool.web.model.user.User;

import com.codecool.web.model.enums.Role;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final DBUserDao userDao;


    public UserService(DBUserDao userDao){
        this.userDao = userDao;

    }

    public List<User> getUsers() throws SQLException {
        return userDao.findUsers();
    }

    public User getUser(String mail) throws SQLException{
        for(User user : userDao.findUsers()){
            if(user.getEmail().equals(mail)){
                return user;
            }
        }
        return null;

    }

    public String notValidated(String name, String email, String role, String passWord) throws SQLException {
        String validated = "newUser";

        for (User user : getUsers()) {
            if ( user.getEmail().equals(email)) {
                validated = "registered";
            } else if (name == null || email == null || role == null|| passWord == null ) {
                validated = "empty";
            }
        }
        return validated;
    }
    public void updateUser(User user) {
        //ellenőrizni van e már regisztált user
        ;

    }

    public void addUser(String name, String email, String role, String passwWord) throws  SQLException {
        userDao.addUser(name, email, role, passwWord);
    }

    public boolean login(String email, String password) throws SQLException {
        for(User user : getUsers()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public void modifyName(Integer id, String name){
        try{
            userDao.updateName(id, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void modifyPassword(Integer id, String password){
        try{
            userDao.updatePassword(id, password);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void modifyMail(Integer id, String mail){
        try{
            userDao.updateMail(id, mail);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

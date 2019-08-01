package com.codecool.web.DAO;

import com.codecool.web.model.user.User;

import java.util.List;

public interface AssigmentDAO {

    public List<User> getUsers();

    public void updateUser(User user);

}

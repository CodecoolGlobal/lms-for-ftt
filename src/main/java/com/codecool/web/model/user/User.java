package com.codecool.web.model.user;

import com.codecool.web.model.enums.Role;

import java.util.Objects;

public class User {
    private int userId;
    private String name;
    private String email;
    private Role role;
    private String password;
    private String roleToString;
    
    public User(String name, String email, String roleToString, String password) {
        this.name = name;
        this.email = email;
        this.role = Role.valueOf(roleToString);
        this.password = password;
    }
    
    public User(int userId, String name, String email, Role role, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.role = role;
        this.password = password;
    }
    
    public User() {

    }
    
    public int getUserId() {
        return userId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public Object getRole() {
        return role;
    }
    
    public String getRoleToString() {
        return roleToString;
    }
}

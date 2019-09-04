package com.codecool.web.model.user;

import com.codecool.web.model.enums.Role;

import java.util.Objects;

public class User {
    private Integer userId;
    private String name;
    private String email;
    private Role role;
    private String password;
    private String roleToString;

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String name, String email, String roleToString, String password) {
        this.name = name;
        this.email = email;
        this.role = Role.valueOf(roleToString);
        this.password = password;
    }

    public User(Integer userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public User(Integer userId, String name, String email, Role role, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public User() {

    }

    public Integer getUserId() {
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

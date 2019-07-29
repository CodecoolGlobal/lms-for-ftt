package com.codecool.web.model.user;

public class User {
    private String userId;
    private String name;
    private String email;
    private String password;
    private boolean role;
    
    public User(String userId, String name, String email, String password, boolean role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
    public String getUserId() {
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
    
    public boolean isRole() {
        return role;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setRole(boolean role) {
        this.role = role;
    }
}

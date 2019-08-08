package com.codecool.web.model.user;

public class User {
    private String userId;
    private String name;
    private String email;
    private String role;
    private String password;

    public User(String name, String email, String role, String password) {
       // this.userId = userId;
        this.name = name;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public User() {

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

    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role){
        this.role = role;
    }
    
}

package com.codecool.web.model.enums;

public enum Role {
    MENTOR("mentor"),
    STUDENT("student");

    private final String val;

    public boolean isEmpty() {
    return false;
    }

    Role (String val){
        this.val = val;
    }
    public String getRole(){
        return val;
    }

    public boolean isStudent(){
        return this == STUDENT;
    }
}

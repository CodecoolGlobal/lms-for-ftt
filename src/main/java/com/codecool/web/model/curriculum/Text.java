package com.codecool.web.model.curriculum;

public class Text extends Page {
    
    private String text;
    
    public Text(String id, String title, String text) {
        super(id, title);
        this.text = text;
    }
    
    public String getText() {
        return text;
    }
}

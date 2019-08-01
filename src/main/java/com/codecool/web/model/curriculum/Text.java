package com.codecool.web.model.curriculum;

public class Text extends Page {
    
    private String text;
    private boolean isPublished;
    
    public Text(String id, String title, String text) {
        super(id, title);
        this.text = text;
        this.isPublished = false;
    }
    
    public Text(String id, String title, String text, boolean isPublished) {
        super(id, title);
        this.text = text;
        this.isPublished = false;
    
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
}

package com.codecool.web.model.curriculum;

public class Text {
    private int id;
    private String title;
    private String text;
    private boolean isPublished;
    
    public Text(String title, String text, boolean isPublished) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.isPublished = false;
    }
    
    public Text(String title, String text) {
        this.title = title;
        this.text = text;
    }
    
    public Text(int id, String title, String text, boolean isPublished) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.isPublished = isPublished;
    }
    
    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getText() {
        return text;
    }
    
    public boolean isPublished() {
        return isPublished;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public void publish() {
        isPublished = true;
    }
    
    public void unpublish() {
        isPublished = false;
    }
    
    @Override
    public String toString() {
        return "Text [id: " + id + ", title: " + title + ", text: " + text + ", published?: " + isPublished + "]";
    }
}

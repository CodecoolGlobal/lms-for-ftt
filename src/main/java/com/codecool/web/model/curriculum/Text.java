package com.codecool.web.model.curriculum;

public class Text {
    private int id;
    private String title;
    private String text;
    private boolean is_Published;
    
    public Text(String title, String text, boolean isPublished) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.is_Published = false;
    }
    
    public Text(String title, String text) {
        this.title = title;
        this.text = text;
    }
    
    public Text(int id, String title, String text, boolean isPublished) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.is_Published = isPublished;
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
        return is_Published;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public void publish() {
        is_Published = true;
    }
    
    public void unpublish() {
        is_Published = false;
    }
    
    @Override
    public String toString() {
        return "Text [id: " + id + ", title: " + title + ", text: " + text + ", published?: " + is_Published + "]";
    }
}

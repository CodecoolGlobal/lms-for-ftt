package com.codecool.web.model.curriculum;

public class Page {
    
    private String id;
    private String title;
    private boolean ispublished;
    
    public Page(String id, String title) {
        this.id = id;
        this.title = title;
        this.ispublished = false;
    }
    
    public String getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public boolean isIspublished() {
        return ispublished;
    }
    
    public void publish() {
        ispublished = true;
    }
    
    public void unPublish() {
        ispublished = false;
    }
}

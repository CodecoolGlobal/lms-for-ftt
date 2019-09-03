package com.codecool.web.model.curriculum;

public class Assignment {
    private int id;
    private String title;
    private String question;
    private int maxScore;
    private boolean is_Published;
    
    public Assignment(String title, String question, int maxScore, boolean is_Published) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.maxScore = maxScore;
        this.is_Published = false;
    }
    
    public Assignment(int id, String title, String question, int maxScore, boolean is_Published) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.maxScore = maxScore;
        this.is_Published = is_Published;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getQuestion() {
        return question;
    }
    
    public boolean isPublished() {
        return is_Published;
    }
    
    public int getMaxScore() {
        return maxScore;
    }
    
    public void publish() {
        is_Published = true;
    }
    
    public void unpublish() {
        is_Published = false;
    }
    
    public int getId() {
        return id;
    }
}

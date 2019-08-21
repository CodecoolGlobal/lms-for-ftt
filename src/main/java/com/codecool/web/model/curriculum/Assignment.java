package com.codecool.web.model.curriculum;

public class Assignment {
    private int id;
    private String title;
    private String question;
    private boolean isPublished;
    private int maxScore;
    
    public Assignment(String title, String question, boolean isPublished, int maxScore) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.isPublished = false;
        this.maxScore = maxScore;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getQuestion() {
        return question;
    }
    
    public boolean isPublished() {
        return isPublished;
    }
    
    public int getMaxScore() {
        return maxScore;
    }
    
    public void publish() {
        isPublished = true;
    }
    
    public void unpublish() {
        isPublished = false;
    }
}

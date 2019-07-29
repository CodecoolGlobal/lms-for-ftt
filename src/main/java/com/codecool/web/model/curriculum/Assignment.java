package com.codecool.web.model.curriculum;

public class Assignment extends Page {
    private String question;
    private int maxScore;
    
    public Assignment(String id, String title, String question, int maxScore) {
        super(id, title);
        this.question = question;
        this.maxScore = maxScore;
    }
    
    public String getQuestion() {
        return question;
    }
    
    public int getMaxScore() {
        return maxScore;
    }
}

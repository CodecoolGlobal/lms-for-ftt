package com.codecool.web.model.curriculum;

public class Solution {
    private int assignmentId;
    private int userId;
    private String userName;
    private String title;
    private String mySolution;
    private int maxScore;
    private int score;
    
    public Solution(int assignmentId, int userId, String userName, String title, String mySolution, int maxScore) {
        this.assignmentId = assignmentId;
        this.userId = userId;
        this.userName = userName;
        this.title = title;
        this.mySolution = mySolution;
        this.maxScore = maxScore;
    }
    
    public Solution(int assignmentId, int userId, String userName, String title, String mySolution, int maxScore, int score) {
        this.assignmentId = assignmentId;
        this.userId = userId;
        this.userName = userName;
        this.title = title;
        this.mySolution = mySolution;
        this.maxScore = maxScore;
        this.score = score;
    }
    
    public int getAssignmentId() {
        return assignmentId;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getMySolution() {
        return mySolution;
    }
    
    public int getMaxScore() {
        return maxScore;
    }
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
}

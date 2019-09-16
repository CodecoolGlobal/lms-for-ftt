package com.codecool.web.model.curriculum;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Solution {
    private int assignmentId;
    private int userId;
    private String userName;
    private String title;
    private String mySolution;
    private int maxScore;
    private int score;
    private LocalDateTime submissionDate;
    
    public Solution(int assignmentId, int userId, String userName, String title, String mySolution, int maxScore) {
        this.assignmentId = assignmentId;
        this.userId = userId;
        this.userName = userName;
        this.title = title;
        this.mySolution = mySolution;
        this.maxScore = maxScore;
        this.submissionDate = LocalDateTime.now();
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
    
    public Solution(int assignmentId, int userId, String userName, String title, String mySolution, int maxScore, int score, LocalDateTime submissionDate) {
        this.assignmentId = assignmentId;
        this.userId = userId;
        this.userName = userName;
        this.title = title;
        this.mySolution = mySolution;
        this.maxScore = maxScore;
        this.score = score;
        this.submissionDate = submissionDate;
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
    
    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
}

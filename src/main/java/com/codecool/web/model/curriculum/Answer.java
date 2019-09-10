package com.codecool.web.model.curriculum;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Answer implements Serializable {
    private int assignmentID;
    private int userID;
    private String solution;
    private int score;
    private LocalDateTime submissionDate;
    
    public Answer(int assignmentID, int userID, String solution) {
        this.assignmentID = assignmentID;
        this.userID = userID;
        this.solution = solution;
        this.submissionDate = LocalDateTime.now();
    }
    
    public Answer(int assignmentID, int userID, String solution, LocalDateTime submissionDate) {
        this.assignmentID = assignmentID;
        this.userID = userID;
        this.solution = solution;
        this.submissionDate = submissionDate;
    }
    
    public int getAssignmentID() {
        return assignmentID;
    }
    
    public int getUserID() {
        return userID;
    }
    
    public String getSolution() {
        return solution;
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

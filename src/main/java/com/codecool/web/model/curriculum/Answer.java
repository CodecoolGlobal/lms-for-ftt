package com.codecool.web.model.curriculum;

import java.time.LocalDate;
import java.util.Date;

public class Answer {
    private int assignmentID;
    private int userID;
    private String solution;
    private int score;
    private LocalDate submissionDate;
    
    public Answer(int assignmentID, int userID, String solution, LocalDate submissionDate) {
        this.assignmentID = assignmentID;
        this.userID = userID;
        this.solution = solution;
        this.submissionDate = LocalDate.now();
    }
    
    public Answer(int assignmentID, String solution) {
        this.assignmentID = assignmentID;
        this.solution = solution;
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
    
    public LocalDate getSubmissionDate() {
        return submissionDate;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
}

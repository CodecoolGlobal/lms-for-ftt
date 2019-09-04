package com.codecool.web.service;

import com.codecool.web.DAO.DBAnswerDao;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class AnswerService {
    private DBAnswerDao answerDao;
    
    public AnswerService(DBAnswerDao answerDao) {
        this.answerDao = answerDao;
    }
    
    public void addSolution(int assignmentId, int userId, String solution, LocalDateTime time) throws SQLException {
        answerDao.addAnswer(assignmentId, userId, solution, time);
    }
}

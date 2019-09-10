package com.codecool.web.service;

import com.codecool.web.DAO.DBAnswerDao;
import com.codecool.web.model.curriculum.Answer;
import com.codecool.web.model.user.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class AnswerService {
    private DBAnswerDao answerDao;
    
    public AnswerService(DBAnswerDao answerDao) {
        this.answerDao = answerDao;
    }
    
    public void addSolution(int assignmentId, int userId, String solution, LocalDateTime time) throws SQLException {
        answerDao.addAnswer(assignmentId, userId, solution, time);
    }
    
    public List<Answer> listByTitle(String title) throws SQLException {
        return answerDao.answerListByTitle(title);
    }
    
    public List<Answer> listByUser(Connection conn, User user) throws SQLException {
        return answerDao.answersByUser(conn, user);
    }
    
    public boolean isAnswered(Connection conn, int assignmentId, int userId) throws  SQLException {
        return answerDao.isAnswered(conn, assignmentId, userId);
    }
    
    public List<Answer> listByAssignmentId(Connection conn, int assignmentID) throws SQLException {
        return answerDao.answersByAssignmentId(conn, assignmentID);
    }
    
    public Answer singleAnswer(Connection conn, User user) throws  SQLException {
        int userId = user.getUserId();
        List<Answer> tempList = answerDao.answersByUser(conn, user);
        if (tempList.size() > 0) {
            return tempList.get(tempList.size() - 1);
        }
    
        return null;
    }
    
    private LocalDateTime localDateFromTimestamp(Timestamp timestamp) {
        return LocalDateTime.ofInstant(timestamp.toInstant(), ZoneOffset.ofHours(0));
    }
}

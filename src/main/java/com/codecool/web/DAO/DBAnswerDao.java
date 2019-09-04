package com.codecool.web.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class DBAnswerDao extends AbstractDao {
    public DBAnswerDao(Connection connection) {
        super(connection);
    }
    
    public void addAnswer(int assignmentId, int userId, String solution, LocalDateTime time) throws SQLException {
        boolean autocomit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        
        String sql = "INSERT INTO answers (assignment_id, user_id, answer, submission_date) VALUES(?, ?, ?, ?)";
        try (PreparedStatement prStm = connection.prepareStatement(sql)) {
            prStm.setInt(1, assignmentId);
            prStm.setInt(2, userId);
            prStm.setString(3, solution);
            prStm.setObject(4, time);
            executeInsert(prStm);
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            connection.setAutoCommit(autocomit);
        }
    }
}

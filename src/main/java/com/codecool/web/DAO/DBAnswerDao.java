package com.codecool.web.DAO;

import com.codecool.web.model.curriculum.Answer;
import com.codecool.web.model.user.User;
import com.codecool.web.service.AssignmentService;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class DBAnswerDao extends AbstractDao {
    private AssignmentService aS;
    
    public DBAnswerDao(Connection connection) {
        super(connection);
    }
    
    public void addAnswer(int assignmentId, int userId, String solution, LocalDateTime time) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        
        String sql = "INSERT INTO answers (assignment_id, user_id, answer, submission_date) VALUES(?, ?, ?, ?)";
        try (PreparedStatement prStm = connection.prepareStatement(sql)) {
            prStm.setInt(1, assignmentId);
            prStm.setInt(2, userId);
            prStm.setString(3, solution);
            prStm.setObject(4, time);
            executeInsert(prStm);
            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            connection.setAutoCommit(autoCommit);
        }
    }
    
    public List<Answer> answerListByTitle(String title) throws SQLException{
        List<Answer> solutions = new ArrayList<>();
        int id = aS.findAssignmentByTitle(title).getId();
        
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        
        String sql = "SELECT * FROM answers WHERE assignment_id= ?";
        try (PreparedStatement prStm = connection.prepareStatement(sql)) {
            prStm.setInt(1, id);
            connection.commit();
    
            ResultSet rs = prStm.executeQuery();
            while (rs.next()) {
                Answer tempAns = new Answer(
                    rs.getInt("assignment_id"),
                    rs.getInt("user_id"),
                    rs.getString("answer"),
                    localDateFromTimestamp(rs.getTimestamp("submission_date")));
                if(rs.getInt("score") != 0) {
                    tempAns.setScore(rs.getInt("score"));
                }
 
                solutions.add(tempAns);
            }
            
        } catch (SQLException ex) {
            connection.rollback();
            ex.printStackTrace();
            
        } finally {
            connection.setAutoCommit(autoCommit);
        }
        
        return solutions;
    }
    
    public List<Answer> answersByUser(User user) throws SQLException {
        List<Answer> solutions = new ArrayList<>();
        int id = user.getUserId();
    
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
    
        String sql = "SELECT * FROM answers WHERE user_id= ?";
        try (PreparedStatement prStm = connection.prepareStatement(sql)) {
            prStm.setInt(2, id);
            connection.commit();
    
            ResultSet rs = prStm.executeQuery();
            while (rs.next()) {
                Answer tempAns = new Answer(
                    rs.getInt("assignment_id"),
                    rs.getInt("user_id"),
                    rs.getString("answer"),
                    localDateFromTimestamp(rs.getTimestamp("submission_date")));
                if(rs.getInt("score") != 0) {
                    tempAns.setScore(rs.getInt("score"));
                }
        
                solutions.add(tempAns);
            }
            
        } catch (SQLException ex) {
            connection.rollback();
            ex.printStackTrace();
            
        } finally {
            connection.setAutoCommit(autoCommit);
        }
        
        return solutions;
    }
    
    private LocalDateTime localDateFromTimestamp(Timestamp timestamp) {
        return LocalDateTime.ofInstant(timestamp.toInstant(), ZoneOffset.ofHours(0));
    }
}

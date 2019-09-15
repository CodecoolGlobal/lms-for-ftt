package com.codecool.web.DAO;

import com.codecool.web.model.curriculum.Answer;
import com.codecool.web.model.curriculum.Solution;
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
        try (PreparedStatement prStm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
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
    
    public List<Answer> answersByUser(Connection connection, User user) throws SQLException {
        List<Answer> solutions = new ArrayList<>();
        int id = user.getUserId();
    
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
    
        String sql = "SELECT * FROM answers WHERE user_id= ?";
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
    
    public boolean isAnswered(Connection conn, int assignmentId, int userId) throws SQLException {
        String sql = "SELECT assignment_id, user_id FROM answers WHERE assignment_id=? AND user_id=?;";
        
        try (PreparedStatement prStmt = conn.prepareStatement(sql)) {
            prStmt.setInt(1, assignmentId);
            prStmt.setInt(2, userId);
            ResultSet rs = prStmt.executeQuery();
            return rs.next();
        }
    }
    
    public List<Answer> answersByAssignmentId(Connection conn, int assignmentId) throws SQLException {
        List<Answer> listByAsId = new ArrayList<>();
        
        String sql = "SELECT * FROM answers WHERE assignment_id=?";
        try (PreparedStatement prStmt = conn.prepareStatement(sql)) {
            prStmt.setInt(1, assignmentId);
            ResultSet rs = prStmt.executeQuery(sql);
            while (rs.next()) {
                listByAsId.add(new Answer(rs.getInt(1), rs.getInt(2), rs.getString(3), localDateFromTimestamp(rs.getTimestamp(4))));
            }
            
            return listByAsId;
        }
    }
    
    public List<Solution> listAllSolutions(Connection connection) throws SQLException {
        List<Solution> solutions = new ArrayList<>();
    
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
    
        String sql = "SELECT answers.assignment_id AS id, answers.user_id AS us_id, users.user_name AS us_name, assignments.title AS title, answers.answer AS solution," +
            "assignments.max_score AS max_score, answers.score AS score FROM answers " +
            "JOIN assignments ON assignments.assignment_id=answers.assignment_id " +
            "JOIN users ON users.user_id=answers.user_id";
        
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Solution tempSol = new Solution(rs.getInt("id"), rs.getInt("us_id"), rs.getString("us_name"), rs.getString("title"), rs.getString("solution"), rs.getInt("max_score"));
                if (rs.getString("score") != null) {
                    tempSol.setScore(rs.getInt("score"));
                }
                solutions.add(tempSol);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return solutions;
    }
    
    public void addScore(Connection conn, int assignmentId, int userId, int myScore) throws SQLException {
        
        String sql = "UPDATE answers SET score=? WHERE assignment_id=? AND user_id= ?";
        try (PreparedStatement prStm = conn.prepareStatement(sql)) {
            prStm.setInt(1, myScore);
            prStm.setInt(2, assignmentId);
            prStm.setInt(3, userId);
    
            prStm.executeUpdate();
        }
    }
    
    private LocalDateTime localDateFromTimestamp(Timestamp timestamp) {
        return LocalDateTime.ofInstant(timestamp.toInstant(), ZoneOffset.ofHours(0));
    }
}

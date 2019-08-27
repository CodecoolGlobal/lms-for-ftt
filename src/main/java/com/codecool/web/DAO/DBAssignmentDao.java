package com.codecool.web.DAO;

import com.codecool.web.model.curriculum.Assignment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBAssignmentDao extends AbstractDao {
    public DBAssignmentDao(Connection connection) {
        super(connection);
    }
    
    public Assignment addAssignment(Assignment assignment) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        
        String title = assignment.getTitle();
        String question = assignment.getQuestion();
        int maxScore = assignment.getMaxScore();
        boolean isPublished = assignment.isPublished();
        
        String sql = "INSERT INTO assignments (title, question, max_score, is_published) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, title);
            statement.setString(2, question);
            statement.setInt(3, maxScore);
            statement.setBoolean(4, isPublished);
            executeInsert(statement);
            int id = fetchGeneratedId(statement);
            return new Assignment(id, assignment.getTitle(), assignment.getQuestion(), assignment.isPublished(), assignment.getMaxScore());
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        } finally {
            connection.setAutoCommit(autoCommit);
        }
    }
    
    public List<Assignment> loadAllAssignments() throws SQLException {
        List<Assignment> allAssignments = new ArrayList<>();
    
        String sql = "SELECT title, question, is_published, max_score FROM assignments";
    
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Assignment assignment = new Assignment(resultSet.getString("title"),
                resultSet.getString("question"),
                resultSet.getBoolean("is_published"),
                resultSet.getInt("max_score"));
                
                
                allAssignments.add(assignment);
            }
        }
        return allAssignments;
    }
}

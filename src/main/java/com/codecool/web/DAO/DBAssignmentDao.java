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
            return new Assignment(id, assignment.getTitle(), assignment.getQuestion(), assignment.getMaxScore(), assignment.isPublished());
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        } finally {
            connection.setAutoCommit(autoCommit);
        }
    }
    
    public List<Assignment> loadAllAssignments() throws SQLException {
        List<Assignment> allAssignments = new ArrayList<>();
    
        String sql = "SELECT assignment_id,title, question, max_score, is_published FROM assignments ORDER BY assignment_id";
    
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Assignment assignment = new Assignment(resultSet.getInt("assignment_id"),
                    resultSet.getString("title"),
                    resultSet.getString("question"),
                    resultSet.getInt("max_score"),
                    resultSet.getBoolean("is_published"));
                
                
                allAssignments.add(assignment);
            }
        }
        return allAssignments;
    }
    
    public void updatePublishing(int id, boolean isPublished) throws  SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        String sql = "UPDATE assignments SET is_published=? WHERE assignment_id= ?";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setBoolean(1, isPublished);
            statement.setInt(2, id);
            executeInsert(statement);
            connection.commit();
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        } finally {
            connection.setAutoCommit(autoCommit);
        }
    }
    
    public Assignment getAssignmentById(Connection conn, int id) throws SQLException {
        Assignment tempAssignment = null;
        
        String sql = "SELECT * FROM assignments WHERE assignment_id= " + id;
        
        try (Statement statement = conn.createStatement()){
            statement.executeQuery(sql);
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                int id1 = rs.getInt("assignment_id");
                String title = rs.getString("title");
                String question = rs.getString("question");
                int maxScore = rs.getInt("max_score");
                boolean published = rs.getBoolean("is_published");
                tempAssignment = new Assignment(id1, title, question, maxScore, published);
            }
            
            if (tempAssignment == null) {
                throw new SQLException("There should something be wrong! No assignment is impossible.");
            }
        }
        
        return tempAssignment;
    }
}

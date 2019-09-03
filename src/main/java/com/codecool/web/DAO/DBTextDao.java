package com.codecool.web.DAO;

import com.codecool.web.model.curriculum.Text;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBTextDao extends AbstractDao {
    public DBTextDao(Connection connection) {
        super(connection);
    }
    
    public Text addText(Text text) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        
        String sql = "INSERT INTO texts (title, text, is_published) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, text.getTitle());
            statement.setString(2, text.getText());
            statement.setBoolean(3, text.isPublished());
            executeInsert(statement);
            int id = fetchGeneratedId(statement);
            return new Text(id, text.getTitle(), text.getText(), text.isPublished());
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        } finally {
            connection.setAutoCommit(autoCommit);
        }
    }
    
    public List<Text> loadAllTexts() throws SQLException {
        List<Text> allText = new ArrayList<>();
        
        String sql = "SELECT text_id, title, text, is_published FROM texts";
    
        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Text text = new Text(
                    resultSet.getInt("text_id"),
                    resultSet.getString("title"),
                    resultSet.getString("text"),
                    resultSet.getBoolean("is_published"));
                
                allText.add(text);
            }
        }
    
        return allText;
    }
    
    public void updatePublishing(int id, boolean isPublished) throws SQLException {
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        String sql = "UPDATE texts SET isPublished=? WHERE page_id=?";
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
}

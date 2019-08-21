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
    
        String sql = "SELECT title, text, is_published FROM texts";
    
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Text text = new Text(
                    resultSet.getString("title"),
                    resultSet.getString("text"));
                if (resultSet.getBoolean("ispublished")) {
                    text.publish();
                } else {
                    text.unpublish();
                }
                allText.add(text);
            }
        }
        return allText;
    }
}

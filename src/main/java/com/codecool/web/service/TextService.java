package com.codecool.web.service;

import com.codecool.web.DAO.DBTextDao;
import com.codecool.web.model.curriculum.Text;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class TextService {
    
    private final DBTextDao textDao;
    
    public TextService(DBTextDao textDao) {
        this.textDao = textDao;
    }
    
    public void addText(Text text) throws SQLException {
        textDao.addText(text);
    }
    
    public List<Text> getAllText() throws SQLException{
        return textDao.loadAllTexts();
    }
    
    public void updateText(String title, String text) throws SQLException {
        for (Text t : getAllText()) {
            if (t.getTitle().equals(title)) {
                t.setText(text);
            }
        }
    }
}

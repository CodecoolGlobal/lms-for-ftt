package com.codecool.web.service;

import com.codecool.web.model.curriculum.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class TextService {
    
    private List<Text> textPages;
    private static TextService myInstance = new TextService();
    
    private TextService() {
        textPages = new ArrayList<>(Arrays.asList(
            new Text("p1", "jazzpage1", "It can be anything.", false),
            new Text("p2", "jazzpage2", "It can even be nothing.", false),
            new Text("p3", "jazzpage3", "... or something.", false)
        ));
    }
    
    public static TextService getMyInstance() {
        return myInstance;
    }
    
    public void addText(Text text) {
        textPages.add(text);
    }
    
    public List<Text> getText() {
        return textPages;
    }
    
    public void updateText(String title, String text) {
        for (Text t : getText()) {
            if (t.getTitle().equals(title)) {
                t.setText(text);
            }
        }
    }
}

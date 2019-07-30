package com.codecool.web.service;

import com.codecool.web.model.curriculum.Page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PageService {
    
    private List<Page>pages;
    private static PageService myInstance = new PageService();
    
    private PageService() {
        pages = new ArrayList<>(Arrays.asList(
            new Page("p1", "jazzpage"),
            new Page("p2", "otherjazz"),
            new Page("p3", "anotherjazz")
        ));
    }
    
    public static PageService getInstance() {
        return myInstance;
    }
    
    public void addPage(Page page) {
        pages.add(page);
    }
    
    public List<Page> getPages() {
        return pages;
    }
}

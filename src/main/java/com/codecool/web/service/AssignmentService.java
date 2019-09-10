package com.codecool.web.service;

import com.codecool.web.DAO.DBAssignmentDao;
import com.codecool.web.model.curriculum.Assignment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public final class AssignmentService {
    
    private final DBAssignmentDao assignmentDao;
    
    public AssignmentService(DBAssignmentDao assignmentDao) {
        this.assignmentDao = assignmentDao;
    }
    
    public void addAssignment(Assignment assignment) throws SQLException {
        assignmentDao.addAssignment(assignment);
    }
    
    public List<Assignment> getAllAssignments() throws SQLException{
        return assignmentDao.loadAllAssignments();
    }
    
    public Assignment findAssignmentByTitle(String title) throws SQLException {
        Assignment assignment = null;
        for (Assignment t : getAllAssignments()) {
            if (t.getTitle().equals(title)) {
               assignment = t;
            }
        }
        return assignment;
    }
    
    public void publishAssignment(String[] publishA) throws SQLException {
        for (String st : publishA) {
            for (Assignment a : getAllAssignments()) {
                int id = Integer.parseInt(st);
                if (id == a.getId()) {
                    if (a.isPublished()) {
                        assignmentDao.updatePublishing(id,  false);
                    } else if (!a.isPublished()){
                        assignmentDao.updatePublishing(id,  true);
                    }
                }
            
            }
        }
    }
    
    public Assignment getById(Connection conn, int id) throws  SQLException {
        return assignmentDao.getAssignmentById(conn, id);
    }
}

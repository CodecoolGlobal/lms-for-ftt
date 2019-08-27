package com.codecool.web.service;

import com.codecool.web.DAO.DBAssignmentDao;
import com.codecool.web.model.curriculum.Assignment;
import com.codecool.web.model.curriculum.Text;

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
}

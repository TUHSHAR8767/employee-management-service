package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.Assignment;
import com.example.employeemanagement.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository repo;

    public Assignment assign(Long empId, Long projId) {
        Assignment a = new Assignment();
        a.setEmployeeId(empId);
        a.setProjectId(projId);
        return repo.save(a);
    }

    public void unassign(Long empId, Long projId) {
        repo.deleteByEmployeeIdAndProjectId(empId, projId);
    }
}
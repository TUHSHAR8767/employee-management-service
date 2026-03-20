package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.Assignment;
import com.example.employeemanagement.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AssignmentController {

    @Autowired
    private AssignmentService service;

    @PostMapping("/assign")
    public Assignment assign(@RequestParam Long empId, @RequestParam Long projId) {
        return service.assign(empId, projId);
    }

    @DeleteMapping("/unassign")
    public void unassign(@RequestParam Long empId, @RequestParam Long projId) {
        service.unassign(empId, projId);
    }
}
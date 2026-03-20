package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee create(@RequestBody Employee e) {
        return service.create(e);
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/filter")
    public List<Employee> filter(@RequestParam String role) {
        return service.filterByRole(role);
    }

    @PutMapping("/{id}/score")
    public Employee updateScore(@PathVariable Long id, @RequestParam Double score) {
        return service.updateScore(id, score);
    }
}
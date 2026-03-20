package com.example.employeemanagement.service;


import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public Employee create(Employee e) {
        return repo.save(e);
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<Employee> filterByRole(String role) {
        return repo.findByRole(role);
    }

    public Employee updateScore(Long id, Double score) {
        Employee e = getById(id);
        e.setScore(score);
        return repo.save(e);
    }
}
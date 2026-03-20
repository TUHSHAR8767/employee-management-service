package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.Project;
import com.example.employeemanagement.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repo;

    public Project create(Project p) {
        return repo.save(p);
    }

    public List<Project> getAll() {
        return repo.findAll();
    }
}
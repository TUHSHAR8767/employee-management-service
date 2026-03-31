package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.Project;
import com.example.employeemanagement.service.ProjectService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @PostMapping
    public Project create(@Valid @RequestBody Project p) {
        return service.create(p);
    }

    @GetMapping
    public List<Project> getAll() {
        return service.getAll();
    }
}
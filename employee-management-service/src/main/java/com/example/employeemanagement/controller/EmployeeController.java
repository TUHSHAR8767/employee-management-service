package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.response.ApiResponse;
import com.example.employeemanagement.service.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    
    @PostMapping
    public ApiResponse<EmployeeDTO> create(@Valid @RequestBody EmployeeDTO dto) {
        EmployeeDTO saved = service.create(dto);
        return new ApiResponse<>(true, "Employee created", saved);
    }

    
    @GetMapping
    public ApiResponse<Page<EmployeeDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Page<EmployeeDTO> data = service.getAll(page, size);
        return new ApiResponse<>(true, "Employee list", data);
    }

    
    @GetMapping("/{id}")
    public ApiResponse<EmployeeDTO> getById(@PathVariable Long id) {
        return new ApiResponse<>(true, "Employee found", service.getById(id));
    }

    
    @PutMapping("/{id}/score")
    public ApiResponse<EmployeeDTO> updateScore(
            @PathVariable Long id,
            @RequestParam Double score) {

        return new ApiResponse<>(true, "Score updated",
                service.updateScore(id, score));
    }

    
    @GetMapping("/filter")
    public ApiResponse<?> filter(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long projectId) {

        return new ApiResponse<>(true, "Filtered result",
                service.filter(name, projectId));
    }
    
    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Long id) {
        service.delete(id);
        return new ApiResponse<>(true, "Employee deleted", null);
    }
}
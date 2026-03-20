package com.example.employeemanagement;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService service;

    @Test
    void testCreateEmployee() {
        
        Employee e = new Employee();
        e.setName("Tushar");
        e.setEmail("tushar@test.com");
        e.setRole("DEV");
        e.setScore(80.0);

        
        Employee saved = service.create(e);

        
        assertNotNull(saved.getId());
        assertEquals("Tushar", saved.getName());
    }
    
    @Test
    void testGetEmployee() {
        Employee e = new Employee();
        e.setName("Test");
        e.setRole("DEV");

        Employee saved = service.create(e);

        Employee found = service.getById(saved.getId());

        assertEquals("Test", found.getName());
    }
}
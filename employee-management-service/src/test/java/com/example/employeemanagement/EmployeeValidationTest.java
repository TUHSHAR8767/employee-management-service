package com.example.employeemanagement;

import com.example.employeemanagement.dto.EmployeeDTO;

import com.example.employeemanagement.service.EmployeeService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("test")   
@SpringBootTest
@Import(TestSecurityConfig.class)
class EmployeeValidationTest {

    @Autowired
    private EmployeeService service;

    @Test
    void testInvalidEmail() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setName("Test");
        dto.setEmail("wrong-email"); // invalid
        dto.setSalary(10000.0);

        assertThrows(Exception.class, () -> service.create(dto));
    }

    @Test
    void testMissingName() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setSalary(10000.0);

        assertThrows(Exception.class, () -> service.create(dto));
    }
}
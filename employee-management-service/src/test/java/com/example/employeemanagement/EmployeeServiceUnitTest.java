package com.example.employeemanagement;

import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.repository.ProjectRepository;
import com.example.employeemanagement.service.EmployeeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceUnitTest {

    @Mock
    private EmployeeRepository repo;

    @Mock
    private ProjectRepository projectRepo;

    @InjectMocks
    private EmployeeService service;

    private Employee employee;

    @BeforeEach
    void setup() {
        employee = new Employee();
        employee.setId(1L);
        employee.setName("Tushar");
        employee.setEmail("tushar@test.com");
        employee.setSalary(50000.0);
    }


    @Test
    void testCreateEmployee() {

        when(repo.save(any(Employee.class))).thenReturn(employee);

        EmployeeDTO dto = new EmployeeDTO();
        dto.setName("Tushar");
        dto.setEmail("tushar@test.com");
        dto.setSalary(50000.0);

        EmployeeDTO result = service.create(dto);

        assertNotNull(result);
        assertEquals("Tushar", result.getName());

        verify(repo, times(1)).save(any(Employee.class));
    }

   
    @Test
    void testGetById() {

        when(repo.findById(1L)).thenReturn(Optional.of(employee));

        EmployeeDTO result = service.getById(1L);

        assertEquals("Tushar", result.getName());
    }

   
    @Test
    void testGetById_NotFound() {

        when(repo.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> service.getById(1L));
    }

 
    @Test
    void testUpdateScore() {

        when(repo.findById(1L)).thenReturn(Optional.of(employee));
        when(repo.save(any(Employee.class))).thenReturn(employee);

        EmployeeDTO result = service.updateScore(1L, 90.0);

        assertEquals(90.0, result.getScore());
    }

    
    @Test
    void testDeleteEmployee() {

        when(repo.findById(1L)).thenReturn(Optional.of(employee));

        service.delete(1L);

        verify(repo, times(1)).delete(employee);
    }
}
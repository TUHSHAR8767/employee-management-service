package com.example.employeemanagement.repository;

import com.example.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    
    List<Employee> findByNameContaining(String name);

    
    @Query("SELECT e FROM Employee e JOIN e.projects p WHERE p.id = :projectId")
    List<Employee> findByProjectId(Long projectId);
}
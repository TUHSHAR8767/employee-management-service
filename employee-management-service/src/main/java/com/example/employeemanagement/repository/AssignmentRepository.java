package com.example.employeemanagement.repository;


import com.example.employeemanagement.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    void deleteByEmployeeIdAndProjectId(Long employeeId, Long projectId);
}

package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.entity.Project;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    @Autowired
    private ProjectRepository projectRepo;

    public EmployeeDTO create(EmployeeDTO dto) {

        Employee e = new Employee();
        e.setName(dto.getName());
        e.setEmail(dto.getEmail());
        e.setPosition(dto.getPosition());
        e.setGender(dto.getGender());
        e.setBirthDate(dto.getBirthDate());
        e.setRecruitmentDate(dto.getRecruitmentDate());
        e.setSalary(dto.getSalary());
        e.setTeam(dto.getTeam());
        e.setScore(dto.getScore());

        if (dto.getProjectIds() != null) {
            List<Project> projects = projectRepo.findAllById(dto.getProjectIds());
            if (projects.size() != dto.getProjectIds().size()) {
                throw new RuntimeException("Invalid project ID");
            }
            e.setProjects(projects);
        }

        Employee saved = repo.save(e);
        return mapToDTO(saved);
    }

    public Page<EmployeeDTO> getAll(int page, int size) {
        Page<Employee> employees = repo.findAll(PageRequest.of(page, size));
        return employees.map(this::mapToDTO);
    }

    public EmployeeDTO getById(Long id) {
        return mapToDTO(repo.findById(id).orElseThrow());
    }

    public EmployeeDTO updateScore(Long id, Double score) {
        Employee e = repo.findById(id).orElseThrow();
        e.setScore(score);
        return mapToDTO(repo.save(e));
    }

    public List<EmployeeDTO> filter(String name, Long projectId) {

        List<Employee> list;

        if (name != null && !name.isEmpty() && projectId != null) {
            list = repo.findByProjectId(projectId)
                    .stream()
                    .filter(e -> e.getName().toLowerCase().contains(name.toLowerCase()))
                    .toList();

        } else if (name != null && !name.isEmpty()) {
            list = repo.findByNameContaining(name);

        } else if (projectId != null) {
            list = repo.findByProjectId(projectId);

        } else {
            list = repo.findAll();
        }

        return list.stream()
                .map(this::mapToDTO)
                .toList();
    }

   
    private EmployeeDTO mapToDTO(Employee e) {

        EmployeeDTO dto = new EmployeeDTO();

        dto.setId(e.getId());
        dto.setName(e.getName());
        dto.setEmail(e.getEmail());
        dto.setPosition(e.getPosition());
        dto.setGender(e.getGender());
        dto.setBirthDate(e.getBirthDate());
        dto.setRecruitmentDate(e.getRecruitmentDate());
        dto.setSalary(e.getSalary());
        dto.setTeam(e.getTeam());
        dto.setScore(e.getScore());

        if (e.getProjects() != null) {
            dto.setProjectIds(
                e.getProjects().stream()
                 .map(Project::getId)
                 .collect(Collectors.toList())
            );
        }

        return dto;
    }
    
    public void delete(Long id) {
        Employee e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));

        repo.delete(e);
    }
}
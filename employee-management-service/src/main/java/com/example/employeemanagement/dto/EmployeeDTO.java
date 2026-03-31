package com.example.employeemanagement.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.*;

public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Name is required") 
    private String name;

    @Email(message = "Invalid email") 
    private String email;

    private String position;
    private String gender;
    private LocalDate birthDate;
    private LocalDate recruitmentDate;

    @NotNull(message = "Salary is required") 
    private Double salary;

    private String team;

    @DecimalMin(value = "0.0", message = "Score must be >= 0")
    @DecimalMax(value = "100.0", message = "Score must be <= 100")
    private Double score;

    private List<Long> projectIds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getRecruitmentDate() {
		return recruitmentDate;
	}

	public void setRecruitmentDate(LocalDate recruitmentDate) {
		this.recruitmentDate = recruitmentDate;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public List<Long> getProjectIds() {
		return projectIds;
	}

	public void setProjectIds(List<Long> projectIds) {
		this.projectIds = projectIds;
	}

}
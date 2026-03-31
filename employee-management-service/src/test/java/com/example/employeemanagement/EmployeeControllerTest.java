package com.example.employeemanagement;

import com.example.employeemanagement.dto.EmployeeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Import(TestSecurityConfig.class) // ✅ FIX
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateEmployeeAPI() throws Exception {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setName("API Test");
        dto.setEmail("api@test.com");
        dto.setSalary(50000.0);
        dto.setPosition("Developer");

        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").value("API Test")) 
                .andExpect(jsonPath("$.data.email").value("api@test.com"));
    }

    @Test
    void testGetEmployeesAPI() throws Exception {
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk());
    }
    
    @Test
    void testInvalidEmployeeAPI() throws Exception {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmail("wrong-email"); // invalid
        dto.setSalary(50000.0);

        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }
    
    @Test
    void testFilterByName() throws Exception {
        mockMvc.perform(get("/employees/filter")
                .param("name", "API"))
                .andExpect(status().isOk());
    }
}
//package com.example.employeemanagement.exception;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.employeemanagement.response.ApiResponse;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ApiResponse<String>> handleRuntime(RuntimeException ex) {
//        return ResponseEntity
//                .status(404)
//                .body(new ApiResponse<>(false, ex.getMessage(), null));
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ApiResponse<String>> handleGeneral(Exception ex) {
//        return ResponseEntity
//                .status(500)
//                .body(new ApiResponse<>(false, "Internal Server Error", null));
//    }
//	
//	
//	
//}




package com.example.employeemanagement.exception;

import com.example.employeemanagement.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // ✅ VALIDATION ERROR (400)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<String>> handleValidation(MethodArgumentNotValidException ex) {

        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        return ResponseEntity
                .badRequest()
                .body(new ApiResponse<>(false, errorMessage, null));
    }

    // ✅ NOT FOUND / BUSINESS ERROR (404)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<String>> handleRuntime(RuntimeException ex) {
        return ResponseEntity
                .status(404)
                .body(new ApiResponse<>(false, ex.getMessage(), null));
    }

    // ✅ GENERIC ERROR (500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGeneral(Exception ex) {
        return ResponseEntity
                .status(500)
                .body(new ApiResponse<>(false, "Internal Server Error", null));
    }
}
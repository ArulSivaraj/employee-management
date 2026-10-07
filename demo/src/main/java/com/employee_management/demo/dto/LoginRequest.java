package com.employee_management.demo.dto;

import jakarta.validation.constraints.*;

public class LoginRequest {

    @Email(message = "Please Provide the vaild email")
    private String email;
    private String password;

    public LoginRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
package com.employee_management.demo.dto;

import jakarta.validation.constraints.*;

public class SignupRequest {

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @Size(max = 10, message = "Mobile must contain 10 digits")
    private String mob_no;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Size(min = 5, message = "Password must greater than 5 Characters")
    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mob_no = mobile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mob_no;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
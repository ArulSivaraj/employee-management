package com.employee_management.demo.controller;

import com.employee_management.demo.entity.Users;
import com.employee_management.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userservice) {
        this.userService = userservice;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody Users users) {

        try {
            Users createdEmployee = userService.createUser(users);

            return ResponseEntity
                    .status(200)
                    .body(
                            Map.of(
                                    "statusCode", 200,
                                    "message", "Employee created successfully",
                                    "data", createdEmployee));
        } catch (Exception e) {
            return ResponseEntity
                    .status(500)
                    .body(
                            Map.of(
                                    "statusCode", 500,
                                    "message", "User creation failed"));
        }
    }

}
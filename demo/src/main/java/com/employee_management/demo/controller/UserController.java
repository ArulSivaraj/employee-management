package com.employee_management.demo.controller;

import com.employee_management.demo.entity.Users;
import com.employee_management.demo.service.UserService;
import com.employee_management.demo.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
        private final UserService userService;

        public UserController(UserService userservice) {
                this.userService = userservice;
        }

        @PostMapping("/signup")
        public ResponseEntity<?> createUser(@Valid @RequestBody SignupRequest signupRequest) {

                try {
                        Users createdEmployee = userService.createUser(
                                        signupRequest.getName(),
                                        signupRequest.getMobile(),
                                        signupRequest.getEmail(),
                                        signupRequest.getPassword());

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

        @PostMapping("/login")
        public ResponseEntity<?> Login(@Valid @RequestBody LoginRequest loginRequest) {
                try {

                        LoginResponse response = userService.login(
                                        loginRequest.getEmail(),
                                        loginRequest.getPassword());

                        return ResponseEntity.ok(
                                        Map.of(
                                                        "statusCode", 200,
                                                        "message", "Login successful",
                                                        "token", response.getToken(),
                                                        "userid", response.getUserId()));

                } catch (Exception e) {

                        return ResponseEntity
                                        .status(401)
                                        .body(
                                                        Map.of(
                                                                        "statusCode", 401,
                                                                        "message", e.getMessage()));
                }
        }

}
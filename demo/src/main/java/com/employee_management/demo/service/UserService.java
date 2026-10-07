package com.employee_management.demo.service;

import com.employee_management.demo.entity.Users;
import com.employee_management.demo.repository.UserRepository;
import com.employee_management.demo.config.SecurityConfig;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.employee_management.demo.dto.*;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public Users createUser(String name, String mobile, String email, String password) {

        Users user = new Users(name, mobile, email, password);
        String encriptedPassword = passwordEncoder.encode(password);
        user.setPassword(encriptedPassword);
        userRepository.save(user);

        return user;
    }

    public LoginResponse login(String email, String password) {

        Users user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email incorrect"));

        boolean passwordMatches = passwordEncoder.matches(
                password,
                user.getPassword());

        if (!passwordMatches) {
            throw new RuntimeException("Password incorrect");
        }
        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponse(token, user.getUserId());

    }
}
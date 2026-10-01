package com.employee_management.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;

    private String user_name;
    private String mob_no;
    private String email;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Character isactive;
    private String password;

    // Default constructor required by JPA
    public Users() {
    }

    // Constructor
    public Users(String username, String mobile, String email) {
        this.user_name = username;
        this.mob_no = mobile;
        this.email = email;
    }

    @PrePersist
    public void onCreate() {
        created_at = LocalDateTime.now();
        updated_at = LocalDateTime.now();

        if (isactive == null) {
            isactive = 'Y';
        }
    }

    @PreUpdate
    public void onUpdate() {
        updated_at = LocalDateTime.now();
    }

    // Getters

    public Long getUserId() {
        return user_id;
    }

    public String getUserName() {
        return user_name;
    }

    public String getMobile() {
        return mob_no;
    }

    public String getEmail() {
        return email;
    }

    public Character getIsActive() {
        return isactive;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreatedAt() {
        return created_at;
    }

    public LocalDateTime getUpdatedAt() {
        return updated_at;
    }

    // Setters

    public void setUserName(String username) {
        this.user_name = username;
    }

    public void setMobile(String mobile) {
        this.mob_no = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsActive(char active) {
        this.isactive = active;
    }
}
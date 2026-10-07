package com.employee_management.demo.dto;

public class LoginResponse{
    private String token;
    private Long userId;

    public LoginResponse(String token, Long userId){
        this.token = token;
        this.userId = userId;
    }

    public void settoken(String token){
        this.token = token;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }

    public String getToken(){
        return token;
    }

    public Long getUserId(){
        return userId;
    }
}
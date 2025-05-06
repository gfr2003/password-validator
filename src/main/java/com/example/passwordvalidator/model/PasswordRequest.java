package com.example.passwordvalidator.model;


import jakarta.validation.constraints.NotBlank;

public class PasswordRequest {

    @NotBlank(message = "Password must not be blank")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
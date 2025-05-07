package com.passwordvalidator.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
@Schema(description = "Password request body")
public class PasswordRequest {

    @NotBlank(message = "Password must not be blank")
    @Schema(description = "The password to be validated", example = "AbTp9!fok", required = true)

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
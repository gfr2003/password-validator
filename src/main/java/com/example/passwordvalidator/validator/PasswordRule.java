package com.example.passwordvalidator.validator;

public interface PasswordRule {
    boolean isValid(String password);
    default String getErrorMessage() {
        return "Validation failed.";
    }
}
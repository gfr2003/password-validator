package com.example.passwordvalidator.validator;

public class HasLowercaseRule implements PasswordRule {
    @Override
    public boolean isValid(String password) {
        return password != null && password.matches(".*[a-z].*");
    }

    @Override
    public String getErrorMessage() {
        return "Password must contain at least one lowercase letter.";
    }
}
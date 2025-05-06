package com.example.passwordvalidator.validator;

public class HasUppercaseRule implements PasswordRule {
    @Override
    public boolean isValid(String password) {
        return password != null && password.matches(".*[A-Z].*");
    }

    @Override
    public String getErrorMessage() {
        return "Password must contain at least one uppercase letter.";
    }
}
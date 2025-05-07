package com.passwordvalidator.validator;

public class HasSpecialCharRule implements PasswordRule {
    @Override
    public boolean isValid(String password) {
        return password != null && password.matches(".*[!@#$%^&*()\\-+].*");
    }

    @Override
    public String getErrorMessage() {
        return "Password must contain at least one special character.";
    }
}
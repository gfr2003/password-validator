package com.example.passwordvalidator.validator;


public class MinLengthRule implements PasswordRule {
    private static final int MIN_LENGTH = 9;

    @Override
    public boolean isValid(String password) {
        return password != null && password.length() >= MIN_LENGTH;
    }

    @Override
    public String getErrorMessage() {
        return "Password must be at least 9 characters.";
    }
}

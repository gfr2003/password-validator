package com.passwordvalidator.validator;

public class NoWhitespaceRule implements PasswordRule {
    @Override
    public boolean isValid(String password) {
        return password != null && !password.contains(" ");
    }
    public String getErrorMessage() {
        return "Password must not contain whitespace.";
    }
}
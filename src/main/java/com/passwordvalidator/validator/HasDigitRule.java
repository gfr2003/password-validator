package com.passwordvalidator.validator;

public class HasDigitRule implements PasswordRule {
    @Override
    public boolean isValid(String password) {
        return password != null && password.matches(".*\\d.*");
    }

    @Override
    public String getErrorMessage() {
        return "Password must contain at least one digit.";
    }
}

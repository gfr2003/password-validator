package com.passwordvalidator.validator;

import java.util.HashSet;
import java.util.Set;

public class NoRepeatedCharRule implements PasswordRule {
    @Override
    public boolean isValid(String password) {
        if (password == null) return false;
        Set<Character> chars = new HashSet<>();
        for (char c : password.toCharArray()) {
            if (!chars.add(c)) return false;
        }
        return true;
    }

    public String getErrorMessage() {
        return "Password must not contain repeated characters.";
    }
}
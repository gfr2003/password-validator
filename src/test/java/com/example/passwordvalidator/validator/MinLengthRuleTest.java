package com.example.passwordvalidator.validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MinLengthRuleTest {

    private final PasswordRule rule = new MinLengthRule();

    @Test
    void shouldReturnTrueWhenPasswordLengthIsValid() {
        String validPassword = "AbTp9!fok";
        assertTrue(rule.isValid(validPassword));
    }

    @Test
    void shouldReturnFalseWhenPasswordLengthIsTooShort() {
        String invalidPassword = "AbTp9!";
        assertFalse(rule.isValid(invalidPassword));
    }

    @Test
    void shouldReturnErrorMessage() {
        assertEquals("Password must be at least 9 characters.", rule.getErrorMessage());
    }
}
package com.example.passwordvalidator.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HasDigitRuleTest {

    private final PasswordRule rule = new HasDigitRule();

    @Test
    void shouldReturnTrueWhenPasswordContainsDigit() {
        String validPassword = "AbTp9!fok";
        assertTrue(rule.isValid(validPassword));
    }

    @Test
    void shouldReturnFalseWhenPasswordDoesNotContainDigit() {
        String invalidPassword = "AbTp!fok";
        assertFalse(rule.isValid(invalidPassword));
    }

    @Test
    void shouldReturnErrorMessage() {
        assertEquals("Password must contain at least one digit.", rule.getErrorMessage());
    }
}

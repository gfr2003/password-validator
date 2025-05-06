package com.example.passwordvalidator.validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HasUpperCaseRuleTest {

    private final PasswordRule rule = new HasUppercaseRule();

    @Test
    void shouldReturnTrueWhenPasswordContainsUppercase() {
        assertTrue(rule.isValid("Password1"));
    }

    @Test
    void shouldReturnFalseWhenPasswordDoesNotContainUppercase() {
        assertFalse(rule.isValid("password1"));
    }

    @Test
    void shouldReturnErrorMessage() {
        assertEquals("Password must contain at least one uppercase letter.", rule.getErrorMessage());
    }
}

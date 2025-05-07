package com.passwordvalidator.validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NoWhitespaceRuleTest {

    private final PasswordRule rule = new NoWhitespaceRule();

    @Test
    void shouldReturnTrueWhenPasswordHasNoWhitespace() {
        assertTrue(rule.isValid("Password1!"));
    }

    @Test
    void shouldReturnFalseWhenPasswordContainsWhitespace() {
        assertFalse(rule.isValid("Password 1!"));
    }

    @Test
    void shouldReturnErrorMessage() {
        assertEquals("Password must not contain whitespace.", rule.getErrorMessage());
    }
}

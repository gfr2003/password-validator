package com.example.passwordvalidator.validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NoRepeatedCharRuleTest {

    private final PasswordRule rule = new NoRepeatedCharRule();

    @Test
    void shouldReturnTrueWhenPasswordHasNoRepeatedCharacters() {
        assertTrue(rule.isValid("Pasword1!"));
    }

    @Test
    void shouldReturnFalseWhenPasswordHasRepeatedCharacters() {
        assertFalse(rule.isValid("Passworrd1!"));
    }

    @Test
    void shouldReturnErrorMessage() {
        assertEquals("Password must not contain repeated characters.", rule.getErrorMessage());
    }
}

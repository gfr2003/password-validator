package com.passwordvalidator.validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HasSpecialCharRuleTest {

    private final PasswordRule rule = new HasSpecialCharRule();

    @Test
    void shouldReturnTrueWhenPasswordContainsSpecialCharacter() {
        assertTrue(rule.isValid("Password1!"));
    }

    @Test
    void shouldReturnFalseWhenPasswordDoesNotContainSpecialCharacter() {
        assertFalse(rule.isValid("Password1"));
    }

    @Test
    void shouldReturnErrorMessage() {
        assertEquals("Password must contain at least one special character.", rule.getErrorMessage());
    }
}

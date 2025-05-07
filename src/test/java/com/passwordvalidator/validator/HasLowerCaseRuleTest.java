package com.passwordvalidator.validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HasLowerCaseRuleTest {

    private final PasswordRule rule = new HasLowercaseRule();

    @Test
    void shouldReturnTrueWhenPasswordContainsLowercase() {
        assertTrue(rule.isValid("Password1"));
    }

    @Test
    void shouldReturnFalseWhenPasswordDoesNotContainLowercase() {
        assertFalse(rule.isValid("PASSWORD1"));
    }

    @Test
    void shouldReturnErrorMessage() {
        assertEquals("Password must contain at least one lowercase letter.", rule.getErrorMessage());
    }
}

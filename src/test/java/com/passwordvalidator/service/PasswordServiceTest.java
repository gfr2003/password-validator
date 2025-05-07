package com.passwordvalidator.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PasswordServiceTest {

    private PasswordService passwordService;

    @BeforeEach
    void setUp() {
        passwordService = new PasswordService();
    }

    @Test
    void shouldReturnEmptyListWhenPasswordIsValid() {
        String validPassword = "AbTp9!fok";
        List<String> errors = passwordService.getValidationErrors(validPassword);
        assertTrue(errors.isEmpty(), "Expected no validation errors");
    }

    @Test
    void shouldReturnErrorsWhenPasswordIsInvalid() {
        String invalidPassword = "abc";
        List<String> errors = passwordService.getValidationErrors(invalidPassword);
        assertFalse(errors.isEmpty(), "Expected validation errors");
    }

    @Test
    void shouldReturnAllErrorsWhenPasswordIsEmpty() {
        String emptyPassword = "";
        List<String> errors = passwordService.getValidationErrors(emptyPassword);

        assertTrue(errors.contains("Password must be at least 9 characters."));
        assertTrue(errors.contains("Password must contain at least one digit."));
        assertTrue(errors.contains("Password must contain at least one lowercase letter."));
        assertTrue(errors.contains("Password must contain at least one uppercase letter."));
        assertTrue(errors.contains("Password must contain at least one special character."));
    }

    @Test
    void shouldReturnFalseWhenPasswordIsInvalid() {
        assertFalse(passwordService.isValid("abc"));
    }

    @Test
    void shouldReturnTrueWhenPasswordIsValid() {
        assertTrue(passwordService.isValid("AbTp9!fok"));
    }
}

package com.example.passwordvalidator.controller;

import com.example.passwordvalidator.service.PasswordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.*;
@WebMvcTest(PasswordController.class)
class PasswordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PasswordService passwordService;

    @Test
    void shouldReturnValidResponseWhenPasswordIsValid() throws Exception {
        String password = "AbTp9!fok";

        when(passwordService.getValidationErrors(password)).thenReturn(List.of());

        mockMvc.perform(post("/api/password/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"password\": \"" + password + "\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(true))
                .andExpect(jsonPath("$.errors").isEmpty());
    }

    @Test
    void shouldReturnInvalidResponseWhenPasswordIsInvalid() throws Exception {
        String password = "abtp9!";

        when(passwordService.getValidationErrors(password)).thenReturn(
                List.of("Password must contain at least one uppercase letter.",
                        "Password must be at least 9 characters."));

        mockMvc.perform(post("/api/password/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"password\": \"" + password + "\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(false))
                .andExpect(jsonPath("$.errors[0]").value("Password must contain at least one uppercase letter."))
                .andExpect(jsonPath("$.errors[1]").value("Password must be at least 9 characters."));
    }

    @Test
    void shouldReturnInvalidWhenPasswordIsEmpty() throws Exception {
        String password = "";

        when(passwordService.getValidationErrors(password)).thenReturn(
                List.of("Password must not be blank"));

        mockMvc.perform(post("/api/password/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"password\": \"" + password + "\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.valid").value(false))
                .andExpect(jsonPath("$.errors").isArray());
    }

    @Test
    void shouldReturnInvalidWhenPasswordHasWhitespace() throws Exception {
        String password = "AbTp9! fo";

        when(passwordService.getValidationErrors(password)).thenReturn(
                List.of("Password must not contain whitespace characters."));

        mockMvc.perform(post("/api/password/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"password\": \"" + password + "\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(false))
                .andExpect(jsonPath("$.errors[0]").value("Password must not contain whitespace characters."));
    }

    @Test
    void shouldReturnInvalidWhenPasswordHasRepeatedCharacters() throws Exception {
        String password = "AbTp9!foo";

        when(passwordService.getValidationErrors(password)).thenReturn(
                List.of("Password must not contain repeated characters."));

        mockMvc.perform(post("/api/password/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"password\": \"" + password + "\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(false))
                .andExpect(jsonPath("$.errors[0]").value("Password must not contain repeated characters."));
    }

    @Test
    void shouldReturnBadRequestWhenPasswordIsMissingFromPayload() throws Exception {
        mockMvc.perform(post("/api/password/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isBadRequest());
    }

}

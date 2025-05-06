package com.example.passwordvalidator.controller;

import com.example.passwordvalidator.model.PasswordRequest;
import com.example.passwordvalidator.model.PasswordResponse;
import com.example.passwordvalidator.service.PasswordService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/password")
public class PasswordController {

    private final PasswordService service;

    public PasswordController(PasswordService service) {
        this.service = service;
    }

    @PostMapping("/validate")
    public ResponseEntity<PasswordResponse> validate( @Valid @RequestBody PasswordRequest request) {
        List<String> errors = service.getValidationErrors(request.getPassword());
        boolean isValid = errors.isEmpty();
        return ResponseEntity.ok(new PasswordResponse(isValid, errors));
    }
}

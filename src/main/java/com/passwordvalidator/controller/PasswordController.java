package com.passwordvalidator.controller;

import com.passwordvalidator.model.PasswordRequest;
import com.passwordvalidator.model.PasswordResponse;
import com.passwordvalidator.service.PasswordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/password")
@Tag(name = "Password Validation", description = "Endpoints for validating passwords")
public class PasswordController {

    private final PasswordService service;

    public PasswordController(PasswordService service) {
        this.service = service;
    }
    @Operation(summary = "Validate password", description = "Validates a password according to security rules")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Validation result",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PasswordResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/validate")
    public ResponseEntity<PasswordResponse> validate( @Valid @RequestBody PasswordRequest request) {
        List<String> errors = service.getValidationErrors(request.getPassword());
        boolean isValid = errors.isEmpty();
        return ResponseEntity.ok(new PasswordResponse(isValid, errors));
    }
}

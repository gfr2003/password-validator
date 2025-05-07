package com.passwordvalidator.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Response for password validation")
public class PasswordResponse {
    @Schema(description = "Indicates if the password is valid")
    private boolean valid;
    @Schema(description = "List of validation error messages")
    private List<String> errors;

    public PasswordResponse(boolean valid, List<String> errors) {
        this.valid = valid;
        this.errors = errors;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}

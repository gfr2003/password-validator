package com.passwordvalidator.service;

import com.passwordvalidator.validator.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PasswordService {

    private final List<PasswordRule> rules = List.of(
        new MinLengthRule(),
        new HasDigitRule(),
        new HasUppercaseRule(),
        new HasLowercaseRule(),
        new HasSpecialCharRule(),
        new NoRepeatedCharRule(),
        new NoWhitespaceRule()
    );

    public boolean isValid(String password) {
        return rules.stream().allMatch(rule -> rule.isValid(password));
    }

    public List<String> getValidationErrors(String password) {
        return rules.stream()
                .filter(rule -> !rule.isValid(password))
                .map(PasswordRule::getErrorMessage)
                .collect(Collectors.toList());
    }
}
package com.example.bookapimanytomany.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NoSingleWordValidator implements ConstraintValidator<NoSingleWord, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().isEmpty()) {
            return true; // skip validation if value is null or empty
        }

        String[] words = value.trim().split("\\s+");
        return words.length > 1; // validate if the input string has more than 1 word
    }
}

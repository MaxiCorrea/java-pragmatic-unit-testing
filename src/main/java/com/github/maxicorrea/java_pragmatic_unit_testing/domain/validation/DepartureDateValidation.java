package com.github.maxicorrea.java_pragmatic_unit_testing.domain.validation;

import java.time.LocalDateTime;

public class DepartureDateValidation implements Validation {

    private LocalDateTime departureDate;

    public DepartureDateValidation(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public boolean isInvalid() {
        return !departureDate.isAfter(LocalDateTime.now());
    }

    @Override
    public String errorMessage() {
        return "Too late!";
    }

}

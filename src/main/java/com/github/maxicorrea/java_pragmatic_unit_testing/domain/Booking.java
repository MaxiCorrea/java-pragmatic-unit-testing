package com.github.maxicorrea.java_pragmatic_unit_testing.domain;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.github.maxicorrea.java_pragmatic_unit_testing.domain.validation.AgeMinimunValidation;
import com.github.maxicorrea.java_pragmatic_unit_testing.domain.validation.AirportCodeValidation;
import com.github.maxicorrea.java_pragmatic_unit_testing.domain.validation.DepartureDateValidation;
import com.github.maxicorrea.java_pragmatic_unit_testing.domain.validation.ItinerarySizeValidation;
import com.github.maxicorrea.java_pragmatic_unit_testing.domain.validation.NameEmptyValidation;
import com.github.maxicorrea.java_pragmatic_unit_testing.domain.validation.Validation;
import com.github.maxicorrea.java_pragmatic_unit_testing.domain.validation.Validator;

public record Booking(
        String name,
        int age, LocalDateTime departureDate,
        List<String> itinerary) {

    public List<String> validate(Validator validator) {
        return validator.validate(validations());
    }

    private List<Validation> validations() {
        return Arrays.asList(
                new AgeMinimunValidation(age),
                new AirportCodeValidation(itinerary),
                new DepartureDateValidation(departureDate),
                new ItinerarySizeValidation(itinerary),
                new NameEmptyValidation(name));
    }

}

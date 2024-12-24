package com.github.maxicorrea.java_pragmatic_unit_testing.domain.validation;

import java.util.List;
import java.util.Set;

public class AirportCodeValidation implements Validation {

    private static final Set<String> AIRPORT_CODES = Set.of("COS", "DEN", "DUB", "PRG");

    private List<String> itinerary;

    public AirportCodeValidation(List<String> itinerary) {
        this.itinerary = itinerary;
    }

    @Override
    public boolean isInvalid() {
        return !itinerary.stream().allMatch((code) -> AIRPORT_CODES.contains(code));
    }

    @Override
    public String errorMessage() {
        return "Itenerary contains invalid airport code";
    }

}

package com.github.maxicorrea.java_pragmatic_unit_testing.domain.validation;

import java.util.List;

public class ItinerarySizeValidation implements Validation {

    private List<String> itinerary;

    public ItinerarySizeValidation(List<String> itinerary) {
        this.itinerary = itinerary;
    }

    @Override
    public boolean isInvalid() {
       return itinerary.size() < 2;
    }

    @Override
    public String errorMessage() {
        return "Itenerary needs 2+ airport codes";
    }
    
}

package com.github.maxicorrea.java_pragmatic_unit_testing.domain.doubles;

public record Address(
        String house_number,
        String road,
        String city,
        String state,
        String postcode,
        String country_code
) {
}
package com.github.maxicorrea.java_pragmatic_unit_testing.domain.assertions;

public record Segment(String origin, String destination, int distance) {
    boolean includes (String airport) {
        return origin.equals(airport) || destination.equals(airport);
    }
}

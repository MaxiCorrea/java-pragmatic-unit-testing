package com.github.maxicorrea.java_pragmatic_unit_testing.domain.assertions;

import java.time.LocalDateTime;

public record Flight(Segment segment, LocalDateTime dateTime) {

    public Flight(String origin, String destination, int distance, LocalDateTime dateTime) {
        this(new Segment(origin, destination, distance), dateTime);
    }

    public boolean includes(String airport) {
        return segment.includes(airport);
    }

}

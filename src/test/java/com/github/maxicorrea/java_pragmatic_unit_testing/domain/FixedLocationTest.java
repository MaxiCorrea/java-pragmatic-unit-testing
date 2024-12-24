package com.github.maxicorrea.java_pragmatic_unit_testing.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.github.maxicorrea.java_pragmatic_unit_testing.domain.Location.Heading;

public class FixedLocationTest {
    
    @Test
    void increasesYCoordinateWhenMovingNorth() {
        assertEquals(new FixedLocation(0, 42, Heading.NORTH),
                new FixedLocation(0, 0, Heading.NORTH).move(42));
    }

    @Test
    void increasesXCoordinateWhenMovingEast() {
        assertEquals(new FixedLocation(3, 0, Heading.EAST),
                new FixedLocation(-2, 0, Heading.EAST).move(5));
    }

    @Test
    void decreasesYCoordinateWhenMovingSouth() {
        assertEquals(new FixedLocation(-2, -4, Heading.SOUTH),
                new FixedLocation(-2, 5, Heading.SOUTH).move(9));
    }

    @Test
    void decreasesXCoordinateWhenMovingWest() {
        assertEquals(new FixedLocation(-14, 5, Heading.WEST),
                new FixedLocation(-2, 5, Heading.WEST).move(12));
    }

}

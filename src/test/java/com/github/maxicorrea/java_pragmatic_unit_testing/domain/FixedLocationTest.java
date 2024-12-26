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

    @Test
    void is0WhenCoordinatesAreTheSame() {
        assertEquals(0, new FixedLocation(1, 2, Heading.NORTH).distanceFrom(1, 2));
    }

    @Test
    void is5InClassicHypotenuseCase() {
        assertEquals(5.0, new FixedLocation(0, 0, Heading.NORTH).distanceFrom(3, 4));
    }

    @Test
    void isNearSomeDoubleValue() {
        assertEquals(5.6568, new FixedLocation(10, 13, Heading.NORTH).distanceFrom(14, 9),
                0.0001);
    }

    @Test
    void worksWithNegativeNumbers() {
        assertEquals(23.7697,
                new FixedLocation(-7, 13, Heading.NORTH).distanceFrom(2, -9),
                0.0001);
    }

}

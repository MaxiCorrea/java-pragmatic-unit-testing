package com.github.maxicorrea.java_pragmatic_unit_testing.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LocationTest {
    
    @Test
    void increaseYCoordinateWhenMovingNorth() {
        Location location = new Location(0, 0, Location.Heading.NORTH);
        location.move(42);
        assertEquals(0, location.getX());
        assertEquals(42, location.getY());
        assertEquals(Location.Heading.NORTH, location.getHeading());
    }

    @Test
    void increasesXCoordinateWhenMovingEast(){
        Location location = new Location(-2, 0, Location.Heading.EAST);
        location.move(5);
        assertEquals(3, location.getX());
        assertEquals(0, location.getY());
        assertEquals(Location.Heading.EAST, location.getHeading());
    }

    @Test
    void decreasesYCoodinateWhenMovingSouth(){
        Location location = new Location(-2, 5, Location.Heading.SOUTH);
        location.move(9);
        assertEquals(-2, location.getX());
        assertEquals(-4, location.getY());
        assertEquals(Location.Heading.SOUTH, location.getHeading());
    }

    @Test
    void decreasesXCoordinateWhenMovingWest() {
        Location location = new Location(-2, 5, Location.Heading.WEST);
        location.move(12);
        assertEquals(-14, location.getX());
        assertEquals(5, location.getY());
        assertEquals(Location.Heading.WEST, location.getHeading());
    }
}

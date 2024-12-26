package com.github.maxicorrea.java_pragmatic_unit_testing.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.maxicorrea.java_pragmatic_unit_testing.domain.Location.Heading;

public class DestinationListTest {

    private static final FixedLocation ORIGIN = new FixedLocation(0, 0, Heading.EAST);
    private static final FixedLocation NORTHEAST = new FixedLocation(3, 3, Heading.NORTH);

    private DestinationList destinationList;

    @BeforeEach
    void setup() {
        destinationList = new DestinationList();
    }

    @Test
    void isEmptyWhenCreated() {
        assertTrue(destinationList.getLocations().isEmpty());
    }

    @Test
    void allowsAddingLocations() {
        destinationList.add(ORIGIN);
        destinationList.add(NORTHEAST);
        assertEquals(List.of(
                ORIGIN,
                NORTHEAST),
                destinationList.getLocations());
    }

    @Test
    void doesNotAddLocationAlreadyContained() {
        destinationList.add(new FixedLocation(0, 0, Heading.EAST));
        destinationList.add(new FixedLocation(3, 3, Heading.NORTH));
        destinationList.add(new FixedLocation(0, 0, Heading.EAST));
        assertEquals(
                List.of(new FixedLocation(0, 0, Heading.EAST),
                        new FixedLocation(3, 3, Heading.NORTH)),
                destinationList.getLocations());
    }

    @Test
    void updateMatchingLocationsWithNewCoordinates() {
        destinationList.add(new FixedLocation(0, 0, Heading.EAST));
        destinationList.add(new FixedLocation(3, 3, Heading.NORTH));
        destinationList.moveLocationWithHeading(Heading.EAST, 3, 3);
        assertEquals(
                List.of(new FixedLocation(3, 3, Heading.EAST),
                        new FixedLocation(3, 3, Heading.NORTH)),
                destinationList.getLocations());
    }

    @Test
    void retainsLocationsLessThanDistance() {
        destinationList.add(new FixedLocation(0, 5, Heading.NORTH));
        destinationList.add(new FixedLocation(0, 10, Heading.NORTH));
        destinationList.add(new FixedLocation(0, 15, Heading.NORTH));
        destinationList.removeLocationsFurtherThan(0, 0, 9);
        assertEquals(List.of(
                new FixedLocation(0, 5, Heading.NORTH)),
                destinationList.getLocations());
    }

}

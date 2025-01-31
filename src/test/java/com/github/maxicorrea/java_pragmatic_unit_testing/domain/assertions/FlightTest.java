package com.github.maxicorrea.java_pragmatic_unit_testing.domain.assertions;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class FlightTest {

    @Test
    void filterAndExtract() {
        var flights = List.of(new Flight("DEN", "DEN", 1000, LocalDateTime.now()));
        assertThat(flights)
                .filteredOn(flight -> flight.includes("DEN"))
                .extracting("segment.distance", Integer.class)
                .allMatch(distance -> distance < 1700);
    }

}

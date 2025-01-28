package com.github.maxicorrea.java_pragmatic_unit_testing.domain.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TimePoolTest {

    @BeforeEach
    void resetPool() {
        TimePool.reset();
    }

    @Test
    void getReturnsTimeInstance() {
        byte four = 4;
        byte twenty = 20;
        assertEquals(new Time(four, twenty), TimePool.get(four, twenty));
    }

    @Test
    void getWithSameValuesReturnsSharedInstance() {
        byte ten = 10;
        byte five = 5;
        var firstRetrieved = TimePool.get(ten, five);
        var secondRetrieved = TimePool.get(ten, five);
        assertSame(firstRetrieved, secondRetrieved);
    }

}

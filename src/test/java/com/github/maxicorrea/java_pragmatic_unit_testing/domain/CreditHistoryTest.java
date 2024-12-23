package com.github.maxicorrea.java_pragmatic_unit_testing.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreditHistoryTest {
    
    CreditHistory creditHistory;

    @BeforeEach
    void setup() {
        creditHistory = new CreditHistory();
    }

    @Test
    void withNoCreditRatingsHas0Mean() {
        int result = creditHistory.arithmeticMean();
        assertEquals(0, result);
    }

    @Test
    void withOneRatingHasEquivalentMean() {
        creditHistory.add(new CreditRating(780));
        int result = creditHistory.arithmeticMean();
        assertEquals(780, result);
    }

}

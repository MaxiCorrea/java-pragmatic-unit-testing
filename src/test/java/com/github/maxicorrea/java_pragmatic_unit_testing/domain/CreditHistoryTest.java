package com.github.maxicorrea.java_pragmatic_unit_testing.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreditHistoryTest {
    
    private CreditHistory creditHistory;

    @BeforeEach
    public void setup() {
        creditHistory = new CreditHistory();
    }

    @Test
    public void withNoCreditRatingsHas0Mean() {
        int result = creditHistory.arithmeticMean();
        assertEquals(0, result);
    }

    @Test
    public void withOneRatingHasEquivalentMean() {
        creditHistory.add(new CreditRating(780));
        int result = creditHistory.arithmeticMean();
        assertEquals(780, result);
    }

}

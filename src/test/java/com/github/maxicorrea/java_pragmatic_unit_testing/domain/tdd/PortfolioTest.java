package com.github.maxicorrea.java_pragmatic_unit_testing.domain.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PortfolioTest {

    Portfolio portfolio;

    @BeforeEach
    void create() {
        portfolio = new Portfolio();
    }

    @Test
    void isEmptyWhenIsCreated() {
        assertTrue(portfolio.isEmpty());
    }

    @Test
    void isNotEmptyAfterPurcharse() {
        portfolio.purcharse("AAPL", 1);
        assertFalse(portfolio.isEmpty());
    }

    @Test
    void hasSizeZeroWhenIsCreated() {
        int expectedSize = 0;
        int currentSize = portfolio.size();
        assertEquals(expectedSize, currentSize);
    }

    @Test
    void hasSize1OnPurchase() {
        portfolio.purcharse("AAPL", 1);
        assertEquals(1, portfolio.size());
    }

    @Test
    void incrementsSizeWithEachPurchaseDifferentSymbol() {
        portfolio.purcharse("AAPL", 1);
        portfolio.purcharse("SONO", 1);
        assertEquals(2, portfolio.size());
    }

    @Test
    void doesNotIncrementSizeWithPurchaseSameSymbol() {
        portfolio.purcharse("AAPL", 1);
        portfolio.purcharse("AAPL", 1);
        assertEquals(1, portfolio.size());
    }

}

package com.github.maxicorrea.java_pragmatic_unit_testing.domain.tdd;

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

}

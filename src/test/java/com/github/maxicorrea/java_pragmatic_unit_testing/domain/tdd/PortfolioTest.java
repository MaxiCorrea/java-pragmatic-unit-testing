package com.github.maxicorrea.java_pragmatic_unit_testing.domain.tdd;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PortfolioTest {
    
    @Test
    void isEmptyWhenIsCreated() {
        Portfolio portfolio = new Portfolio();
        assertTrue(portfolio.isEmpty());
    }

}

package com.github.maxicorrea.java_pragmatic_unit_testing.domain.tdd;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
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

    @Test
    void returnsSharesGivenSymbol() {
        portfolio.purcharse("AAPL", 42);
        assertEquals(42, portfolio.sharesOf("AAPL"));
    }

    @Test
    void separatesSharesBySymbol() {
        portfolio.purcharse("SONO", 42);
        portfolio.purcharse("AAPL", 1);
        assertEquals(42, portfolio.sharesOf("SONO"));
    }

    @Test
    void returns0SharesForSymbolNotPurchased() {
        assertEquals(0, portfolio.sharesOf("SONO"));
    }

    @Test
    void accumulatesSharesOfSameSymbolPurchase() {
        portfolio.purcharse("SONO", 42);
        portfolio.purcharse("SONO", 100);
        assertEquals(142, portfolio.sharesOf("SONO"));
    }

    @Test
    void reducesSharesOnSell() {
        portfolio.purcharse("AAPL", 100);
        portfolio.sell("AAPL", 25);
        assertEquals(75, portfolio.sharesOf("AAPL"));
    }

    @Test
    void throwsWhenSellingMoreSharesThanHeld() {
        portfolio.purcharse("AAPL", 10);
        assertThrows(InvalidTransactionException.class, () -> portfolio.sell("AAPL", 10 + 1));
    }

    @Test
    void reducesSizeWhenLiquidatingSymbol() {
        portfolio.purcharse("AAPL", 50);
        portfolio.sell("AAPL", 50);
        assertEquals(0, portfolio.size());
    }

    @Test
    void returnsNullWhenNoPreviousTransactionMade() {
        assertNull(portfolio.lastTransaction());
    }

    @Nested
    public class LastTransaction {
        Instant now = Instant.now();

        @BeforeEach
        public void injectFixedClock() {
            Clock clock = Clock.fixed(now, ZoneId.systemDefault());
            portfolio.setClock(clock);
        }

        @Test
        void returnsLastTransactionAfterPurchase() {
            portfolio.purcharse("SONO", 20);
            assertEquals(portfolio.lastTransaction(), new Transaction("SONO", 20, TransactionType.BUY, now));
        }

        @Test
        void returnsLastTransactionAfterSale() {
            portfolio.purcharse("SONO", 200);
            portfolio.sell("SONO", 40);
            assertEquals(new Transaction("SONO", 40, TransactionType.SELL, now), portfolio.lastTransaction());
        }

    }

    @Nested
    public class TransactionHistory {
        Instant now = Instant.now();

        @BeforeEach
        public void injectFixedClock() {
            Clock clock = Clock.fixed(now, ZoneId.systemDefault());
            portfolio.setClock(clock);
        }

        @Test
        void returnsEmptyListWhenNoTransactionsMade() {
            assertTrue(portfolio.transactions().isEmpty());
        }

        @Test
        void returnsListOfTransactionsReverseChronologically() {
            portfolio.purcharse("A", 1);
            portfolio.purcharse("B", 2);
            portfolio.purcharse("C", 3);
            assertEquals(portfolio.transactions(), List.of(
                    new Transaction("C", 3, TransactionType.BUY, now),
                    new Transaction("B", 2, TransactionType.BUY, now),
                    new Transaction("A", 1, TransactionType.BUY, now)));
        }

    }

}

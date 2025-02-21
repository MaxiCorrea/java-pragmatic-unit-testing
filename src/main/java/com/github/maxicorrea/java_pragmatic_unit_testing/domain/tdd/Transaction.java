package com.github.maxicorrea.java_pragmatic_unit_testing.domain.tdd;

import java.time.Instant;

public record Transaction(
        String symbol, int shares, TransactionType type, Instant now) {
}

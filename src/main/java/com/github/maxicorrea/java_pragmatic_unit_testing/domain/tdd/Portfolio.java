package com.github.maxicorrea.java_pragmatic_unit_testing.domain.tdd;

import java.time.Clock;
import java.util.HashMap;
import java.util.Map;

public class Portfolio {

    private Clock clock;
    private Transaction lastTransaction;
    private Map<String, Integer> purcharses;

    public Portfolio() {
        clock = Clock.systemUTC();
        purcharses = new HashMap<>();
    }

    public boolean isEmpty() {
        return purcharses.isEmpty();
    }

    public void purcharse(String symbol, int shares) {
        updateShares(symbol, +shares, TransactionType.BUY);
    }

    public int size() {
        return purcharses.size();
    }

    public int sharesOf(String symbol) {
        return purcharses.getOrDefault(symbol, 0);
    }

    public void sell(String symbol, int shares) {
        abortOnOversell(symbol, shares);
        updateShares(symbol, -shares, TransactionType.SELL);
        removeSymbolIfSoldOut(symbol);
    }

    private void abortOnOversell(String symbol, int shares) {
        if (sharesOf(symbol) < shares)
            throw new InvalidTransactionException();
    }

    private void updateShares(String symbol, int shares, TransactionType type) {
        lastTransaction = new Transaction(symbol, Math.abs(shares), type, clock.instant());
        purcharses.put(symbol, sharesOf(symbol) + shares);
    }

    private void removeSymbolIfSoldOut(String symbol) {
        if (sharesOf(symbol) == 0)
            purcharses.remove(symbol);
    }

    public Transaction lastTransaction() {
        return lastTransaction;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }

}

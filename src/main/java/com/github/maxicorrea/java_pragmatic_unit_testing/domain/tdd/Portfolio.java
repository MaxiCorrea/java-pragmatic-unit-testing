package com.github.maxicorrea.java_pragmatic_unit_testing.domain.tdd;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {

    private Map<String, Integer> purcharses;

    public Portfolio() {
        purcharses = new HashMap<>();
    }

    public boolean isEmpty() {
        return purcharses.isEmpty();
    }

    public void purcharse(String symbol, int shares) {
        updateShares(symbol, +shares);
    }

    public int size() {
        return purcharses.size();
    }

    public int sharesOf(String symbol) {
        return purcharses.getOrDefault(symbol, 0);
    }

    public void sell(String symbol, int shares) {
        abortOnOversell(symbol, shares);
        updateShares(symbol, -shares);
    }

    private void abortOnOversell(String symbol, int shares) {
        if (sharesOf(symbol) < shares)
            throw new InvalidTransactionException();
    }

    private void updateShares(String symbol, int shares) {
        purcharses.put(symbol, sharesOf(symbol) + shares);
    }

}

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
        purcharses.put(symbol, sharesOf(symbol) + shares);
    }

    public int size() {
        return purcharses.size();
    }

    public int sharesOf(String symbol) {
        return purcharses.getOrDefault(symbol, 0);
    }

}

package com.github.maxicorrea.java_pragmatic_unit_testing.domain.tdd;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {

    private Map<String, Integer> symbols;
    
    public Portfolio() {
        symbols = new HashMap<>();
    }

    public boolean isEmpty() {
        return symbols.isEmpty();
    }

    public void purcharse(String symbol, int shares) {
        symbols.put(symbol, shares);
    }

    public int size() {
        return symbols.size();
    }

    public int sharesOf(String symbol) {
        return symbols.get(symbol);
    }

}

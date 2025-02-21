package com.github.maxicorrea.java_pragmatic_unit_testing.domain.tdd;

import java.util.HashSet;
import java.util.Set;

public class Portfolio {

    private Set<String> symbols = new HashSet<>();
    private int shares;

    public boolean isEmpty() {
        return symbols.isEmpty();
    }

    public void purcharse(String symbol, int shares) {
        symbols.add(symbol);
        this.shares = shares;
    }

    public int size() {
       return symbols.size();
    }

    public int sharesOf(String symbol) {
       return shares;
    }
    
}

package com.github.maxicorrea.java_pragmatic_unit_testing.domain.tdd;

import java.util.HashSet;
import java.util.Set;

public class Portfolio {

    private Set<String> symbols = new HashSet<>();

    public boolean isEmpty() {
        return symbols.isEmpty();
    }

    public void purcharse(String symbol, int shares) {
        symbols.add(symbol);
    }

    public int size() {
       return symbols.size();
    }
    
}

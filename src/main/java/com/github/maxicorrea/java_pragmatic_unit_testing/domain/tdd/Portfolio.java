package com.github.maxicorrea.java_pragmatic_unit_testing.domain.tdd;

public class Portfolio {

    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public void purcharse(String synbol, int shares) {
        size++;
    }

    public int size() {
       return size;
    }
    
}

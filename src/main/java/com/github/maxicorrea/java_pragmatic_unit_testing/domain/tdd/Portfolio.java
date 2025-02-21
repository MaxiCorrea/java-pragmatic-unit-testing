package com.github.maxicorrea.java_pragmatic_unit_testing.domain.tdd;

public class Portfolio {

    private boolean isEmpty = true;

    public boolean isEmpty() {
        return isEmpty;
    }

    public void purcharse(String synbol, int shares) {
        isEmpty = false;
    }

    public int size() {
       return 0;
    }
    
}

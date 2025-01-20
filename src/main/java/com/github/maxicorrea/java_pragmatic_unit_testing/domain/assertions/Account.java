package com.github.maxicorrea.java_pragmatic_unit_testing.domain.assertions;

import java.math.BigDecimal;

public class Account {
    
    private BigDecimal balance;

    public Account(String name) {
        this.balance = BigDecimal.ZERO;
    }

    public void deposit(int balance) {
        this.balance = this.balance.add(BigDecimal.valueOf(balance));
    }

    public boolean hasPositiveBalance() {
        return BigDecimal.ZERO.compareTo(balance) < 0;
    }

}

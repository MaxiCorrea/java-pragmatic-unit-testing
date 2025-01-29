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

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal withdraw(BigDecimal balance) {
        if(this.balance.subtract(balance).compareTo(BigDecimal.ZERO) < 0)
            throw new InsufficientFundsException(String.format("balance only %s", this.balance));
        return (this.balance = this.balance.subtract(balance));
    }

}

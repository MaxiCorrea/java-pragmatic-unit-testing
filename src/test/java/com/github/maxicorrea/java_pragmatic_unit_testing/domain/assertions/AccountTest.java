package com.github.maxicorrea.java_pragmatic_unit_testing.domain.assertions;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

    Account account;

    @BeforeEach
    void createAccount() {
        account = new Account("an account name");
    }

    @Test
    void hasPositiveBalanceAfterInitialDeposit() {
        account.deposit(50);
        Assertions.assertTrue(account.hasPositiveBalance());
    }

    @Test
    void depositIncreasesBalanceByAmountDeposited() {
        account.deposit(50);
        account.deposit(20);
        Assertions.assertEquals(BigDecimal.valueOf(70), account.getBalance(),
                "account balance must be total of deposits");
    }

}

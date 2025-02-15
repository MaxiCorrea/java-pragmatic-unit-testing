package com.github.maxicorrea.java_pragmatic_unit_testing.domain.assertions;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("account")
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

    @Test
    void doesNotHavePositiveBalanceWhenAccountCreated() {
        assertFalse(account.hasPositiveBalance());
    }

    @Test
    void throwsWhenWithdrawingTooMuch() {
        var thrown = assertThrows(InsufficientFundsException.class,
                () -> account.withdraw(BigDecimal.valueOf(100)));
       assertEquals("balance only 0", thrown.getMessage());
    }


    @Nested
    class Withdrawal {
        @Test void reducesAccountBalance() { /* ... */ }
        @Test void throwsWhenAmountExceedsBalance() { /* ... */ }
        @Test void notifiesIRSWhenAmountExceedsThreshold() { /* ... */ }
    }
    

}

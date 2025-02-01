package com.github.maxicorrea.java_pragmatic_unit_testing.domain.assertions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class FundedAccountTest {

    Account account = new Account("Jeff");

    public FundedAccountTest() {
        System.out.println("FundedAccountTest");
    }

    @BeforeEach
    public void fundAccount() {
        account.deposit(1000);
        System.out.println("fundAccount");
    }

    @BeforeAll
    public static void clearAccountRegistry() {
        System.out.println("clearAccountRegistry");
    }

    @Nested
    public class AccruingInterest {

        @BeforeEach
        public void setInterestRate() {
            System.out.println("AccruingInterest : setInterestRate");
        }

        @Test
        public void occursWhenMinimumMet() {
            System.out.println("AccruingInterest : occursWhenMinimumMet");
        }

        @Test
        public void doesNotOccurWhenMinimumNotMet() {
            System.out.println("AccruingInterest : doesNotOccurWhenMinimumNotMet");
        }

        @Test
        public void isReconciledWithMasterAccount() {
            System.out.println("AccruingInterest : isReconciledWithMasterAccount");
        }

    }

    @Nested
    public class Withdrawal {
        @Test
        public void reducesAccountBalance() {
            System.out.println("Withdrawal : reducesAccountBalance");
        }

        @Test
        public void throwsWhenAmountExceedsBalance() {
            System.out.println("Withdrawal : throwsWhenAmountExceedsBalance");
        }

        @Test
        public void notifiesIRSWhenAmountExceedsThreshold() {
            System.out.println("Withdrawal : notifiesIRSWhenAmountExceedsThreshold");
        }
    }

}

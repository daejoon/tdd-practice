package com.ddoong2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws Exception {
        account = new Account(10000);
    }

    @Test
    public void test_getBalance() {
        assertEquals(10000, account.getBalance());

        account = new Account(1000);
        assertEquals(1000, account.getBalance());

        account = new Account(0);
        assertEquals(0, account.getBalance());
    }

    @Test
    public void test_deposit() {
        account.deposit(1000);
        assertEquals(11000, account.getBalance());
    }

    @Test
    public void test_withdraw() {
        account.withdraw(1000);
        assertEquals(9000, account.getBalance());
    }

}

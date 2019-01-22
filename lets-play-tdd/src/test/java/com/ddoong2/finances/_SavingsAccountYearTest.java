package com.ddoong2.finances;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _SavingsAccountYearTest {

    @Test
    public void startingBalance() {
        SavingAccountYear account = new SavingAccountYear(10000, 10);
        assertEquals(10000, account.staringBalance());
    }

    @Test
    public void endingBalance() {
        SavingAccountYear account = new SavingAccountYear(10000, 10);
        assertEquals(11000, account.endingBalance());
    }

    @Test
    public void nextYearStartingBalanceShouldEqualThisYearsEndingBalance() {
        SavingAccountYear thisYear = new SavingAccountYear(10000, 10);
        assertEquals(thisYear.endingBalance(), thisYear.nextYear().staringBalance());
    }

    @Test
    public void nextYearsInterestRateEqualsThisYearsInterestRate() {
        SavingAccountYear thisYear = new SavingAccountYear(10000, 10);
        assertEquals(thisYear.interestRate(), thisYear.nextYear().interestRate());
    }
}

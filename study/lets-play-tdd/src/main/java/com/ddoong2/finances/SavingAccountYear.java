package com.ddoong2.finances;

public class SavingAccountYear {
    private int startingBalance = 0;
    private int interestRate;

    public SavingAccountYear() {
    }

    public SavingAccountYear(int startingBalance, int interestRate) {
        this.startingBalance = startingBalance;
        this.interestRate = interestRate;
    }

    public int staringBalance() {
        return startingBalance;
    }

    public void deposit(int account) {
        startingBalance += account;
    }

    public int balance() {
        return startingBalance;
    }

    public void withdraw(int account) {
        startingBalance -= account;
    }

    public SavingAccountYear nextYear() {
        return new SavingAccountYear(this.endingBalance(), this.interestRate);
    }

    public int endingBalance() {
        return balance() + (balance() * interestRate / 100);
    }

    public int interestRate() {
        return interestRate;
    }
}

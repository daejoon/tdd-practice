package com.ddoong2.finances;

public class Main {

    public static void main(String[] args) {
        SavingAccountYear account = new SavingAccountYear();
        account.deposit(10000);

        for (int i = 0; i < 60; i++) {
            System.out.println(i + ": $" + account.balance());
            account = account.nextYear();
        }
    }
}

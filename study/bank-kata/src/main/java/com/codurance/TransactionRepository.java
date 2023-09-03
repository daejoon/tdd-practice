package com.codurance;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class TransactionRepository {

    private Clock clock;
    private List<Transaction> transactions = new ArrayList<>();

    public TransactionRepository(Clock clock) {
        this.clock = clock;
    }

    public void addDeposit(int amount) {
        Transaction deposit = new Transaction(clock.todayAsString(), amount);
        transactions.add(deposit);
    }

    public void addWithdrawal(int amount) {
        Transaction withdrawal = new Transaction(clock.todayAsString(), -amount);
        transactions.add(withdrawal);
    }

    public List<Transaction> allTransactions() {
        return unmodifiableList(transactions);
    }
}

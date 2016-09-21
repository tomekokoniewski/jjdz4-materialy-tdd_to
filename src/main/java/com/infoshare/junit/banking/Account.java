package com.infoshare.junit.banking;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Account {
    private String owner;
    private BigDecimal balance = BigDecimal.ZERO;
    private List<Transaction> transactions = new ArrayList<Transaction>();

    public Account(String owner) {
        this.owner = owner;
    }

    public List<Transaction> history() {
        return ImmutableList.copyOf(transactions);
    }

    public void register(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> historyBetween(LocalDate start, LocalDate end) {
        return transactions.stream().filter((transaction -> {
            LocalDate d = transaction.getDate();
            return d.isAfter(start) && d.isBefore(end);
        })).collect(Collectors.toList());
    }
}

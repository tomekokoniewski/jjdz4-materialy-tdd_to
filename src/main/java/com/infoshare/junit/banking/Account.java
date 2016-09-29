package com.infoshare.junit.banking;

import com.google.common.collect.ImmutableSet;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Set;
import java.util.stream.Collectors;

public class Account extends Observable {
    private String owner;
    private BigDecimal balance = BigDecimal.ZERO;
    private Set<Transaction> transactions = new HashSet<>();

    public Account(String owner) {
        this.owner = owner;
    }

    public Set<Transaction> history() {
        return ImmutableSet.copyOf(transactions);
    }

    public void register(Transaction transaction) throws DuplicatedTransactionException {
        if (transactions.contains(transaction)) {
            throw new DuplicatedTransactionException();
        }
        transactions.add(transaction);
        notifyObservers(transaction);
    }

    public List<Transaction> historyBetween(LocalDate start, LocalDate end) {
        return transactions.stream().filter((transaction -> {
            LocalDateTime d = transaction.getDate();
            return d.isAfter(start.atStartOfDay()) && d.isBefore(end.atStartOfDay());
        })).collect(Collectors.toList());
    }
}

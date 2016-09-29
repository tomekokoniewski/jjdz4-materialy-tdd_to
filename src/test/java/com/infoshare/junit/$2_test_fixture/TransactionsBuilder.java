package com.infoshare.junit.$2_test_fixture;

import com.infoshare.junit.banking.Account;
import com.infoshare.junit.banking.DuplicatedTransactionException;
import com.infoshare.junit.banking.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.stream.DoubleStream;

public class TransactionsBuilder {
    private final Random rand = new Random();
    private int total = 100;
    private LocalDateTime before = LocalDateTime.now();
    private LocalDateTime after = before.minus(Period.ofMonths(1));
    private long diffMinutes;
    private long minValue;
    private long maxValue;

    public TransactionsBuilder after(LocalDateTime dateTime) {
        after = dateTime;
        return this;
    }

    public TransactionsBuilder before(LocalDateTime dateTime) {
        before = dateTime;
        diffMinutes = ChronoUnit.MINUTES.between(after,before);
        return this;
    }

    public TransactionsBuilder totalOf(int transactionCount) {
        total = transactionCount;
        return this;
    }

    public TransactionsBuilder valueBetween(long min, long max) {
        minValue = min;
        maxValue = max;
        return this;
    }

    public void register(Account account) {
        Random rand = new Random();
        DoubleStream doubles = rand.doubles(total, minValue, maxValue);
        doubles.forEach(value -> {
            try {
                LocalDateTime date = getRandomDate();
                Transaction transaction = new Transaction(BigDecimal.valueOf(value), date);
                account.register(transaction);
            } catch (DuplicatedTransactionException e) {
                e.printStackTrace();
            }
        });
    }

    private LocalDateTime getRandomDate() {
        return after.plusMinutes(rand.nextInt((int) diffMinutes + 1));
    }

}

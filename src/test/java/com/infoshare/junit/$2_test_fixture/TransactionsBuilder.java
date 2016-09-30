package com.infoshare.junit.$2_test_fixture;

import com.infoshare.junit.banking.Account;
import com.infoshare.junit.banking.DuplicatedTransactionException;
import com.infoshare.junit.banking.NullTransactionException;
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
    private DateGenerator dateGenerator = new LinearDateGenerator();

    public TransactionsBuilder after(LocalDateTime dateTime) {
        after = dateTime;
        return this;
    }

    public TransactionsBuilder withRandomDates() {
        dateGenerator = new RandomDateGenerator();
        return this;
    }

    public TransactionsBuilder withLinearDates() {
        dateGenerator = new LinearDateGenerator();
        return this;
    }

    public TransactionsBuilder before(LocalDateTime dateTime) {
        before = dateTime;
        diffMinutes = ChronoUnit.MINUTES.between(after, before);
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
        long d = diffMinutes / total;
        final int[] transactionCount = {0};
        doubles.forEach(value -> {
            try {
                LocalDateTime nextDate = dateGenerator.getNextDate(after, d, transactionCount[0]);
                Transaction transaction = new Transaction(BigDecimal.valueOf(value), nextDate);
                account.register(transaction);
                transactionCount[0]++;
            } catch (DuplicatedTransactionException | NullTransactionException e) {
                e.printStackTrace();
            }
        });
    }

}

interface DateGenerator {
    LocalDateTime getNextDate(LocalDateTime start, long periodBetweenDates, int transactionNum);
}

class LinearDateGenerator implements DateGenerator {
    public LocalDateTime getNextDate(LocalDateTime start, long periodBetweenDates, int transactionNum) {
        return start.plusMinutes(periodBetweenDates* transactionNum);
    }
}

class RandomDateGenerator implements DateGenerator {
    public LocalDateTime getNextDate(LocalDateTime start, long periodBetweenDates,int transactionNum){
        return start.plusMinutes(new Random().nextInt((int)periodBetweenDates+1));
    }
}
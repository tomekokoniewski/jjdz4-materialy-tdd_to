package com.infoshare.junit.$2_test_fixture;

import com.google.common.collect.ImmutableList;
import com.infoshare.junit.banking.Account;
import com.infoshare.junit.banking.Transaction;
import org.junit.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.assertThat;

/**
 * przykład użycia before/after, beforeClass/afterClass
 */
public class TransactionSetupTest {

    @Test
    public void new_account_should_not_have_any_transactions() {
        String owner = "Kent Beck";
        Account account = new Account(owner);
        assertThat(account.history(), is(empty()));
    }

    @Test
    public void should_find_all_transactions() {
        Account account = new Account("Kent Beck");
        ImmutableList<Transaction> transactions = ImmutableList.of(
                new Transaction(BigDecimal.valueOf(100), LocalDate.of(2015, Month.DECEMBER, 1)),
                new Transaction(BigDecimal.valueOf(200), LocalDate.of(2015, Month.DECEMBER, 24)),
                new Transaction(BigDecimal.valueOf(30.12), LocalDate.of(2016, Month.JANUARY, 12)),
                new Transaction(BigDecimal.valueOf(51), LocalDate.of(2016, Month.FEBRUARY, 3)),
                new Transaction(BigDecimal.valueOf(0), LocalDate.of(2016, Month.MARCH, 15))
        );
        transactions.stream().forEach((transaction -> account.register(transaction)));
        assertThat(account.history(), hasSize(transactions.size()));
    }

    @Test
    public void should_find_transactions_from_specific_period() {
        Account account = new Account("Kent Beck");
        ImmutableList<Transaction> transactions = ImmutableList.of(
                new Transaction(BigDecimal.valueOf(100), LocalDate.of(2015, Month.DECEMBER, 1)),
                new Transaction(BigDecimal.valueOf(200), LocalDate.of(2015, Month.DECEMBER, 24)),
                new Transaction(BigDecimal.valueOf(30.12), LocalDate.of(2016, Month.JANUARY, 12)),
                new Transaction(BigDecimal.valueOf(51), LocalDate.of(2016, Month.FEBRUARY, 3)),
                new Transaction(BigDecimal.valueOf(0), LocalDate.of(2016, Month.MARCH, 15))
        );
        transactions.stream().forEach((transaction -> account.register(transaction)));
        LocalDate start = LocalDate.of(2016, 1, 1);
        LocalDate end = LocalDate.of(2016, 4, 1);
        assertThat(account.historyBetween(start, end), is(not(empty())));
    }

}

package com.infoshare.junit.$2_test_fixture;

import com.google.common.collect.ImmutableList;
import com.infoshare.junit.banking.Account;
import com.infoshare.junit.banking.Transaction;
import org.junit.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.assertThat;

public class TransactionSetupTest {

    @BeforeClass
    public static void createDBConnection() {
    }

    @Before
    public void prepareTransactions() {
    }

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
                new Transaction(LocalDate.of(2015, Month.DECEMBER, 1)),
                new Transaction(LocalDate.of(2015, Month.DECEMBER, 24)),
                new Transaction(LocalDate.of(2016, Month.JANUARY, 12)),
                new Transaction(LocalDate.of(2016, Month.FEBRUARY, 3)),
                new Transaction(LocalDate.of(2016, Month.MARCH, 15)));
        transactions.stream().forEach((transaction -> account.register(transaction)));
        assertThat(account.history(), hasSize(transactions.size()));
    }

    @Test
    public void should_find_transactions_from_specific_period() {
        Account account = new Account("Kent Beck");
        ImmutableList<Transaction> transactions = ImmutableList.of(
                new Transaction(LocalDate.of(2015, Month.DECEMBER, 1)),
                new Transaction(LocalDate.of(2015, Month.DECEMBER, 24)),
                new Transaction(LocalDate.of(2016, Month.JANUARY, 12)),
                new Transaction(LocalDate.of(2016, Month.FEBRUARY, 3)),
                new Transaction(LocalDate.of(2016, Month.MARCH, 15)));
        transactions.stream().forEach((transaction -> account.register(transaction)));
        LocalDate start = LocalDate.of(2016, 1, 1);
        LocalDate end = LocalDate.of(2016, 4, 1);
        assertThat(account.historyBetween(start, end), is(not(empty())));
    }

    @Test
    public void transaction_lists_from_the_same_period_are_equal() {
        Account account = new Account("Kent Beck");
        ImmutableList<Transaction> transactions = ImmutableList.of(
                new Transaction(LocalDate.of(2015, Month.DECEMBER, 1)),
                new Transaction(LocalDate.of(2015, Month.DECEMBER, 24)),
                new Transaction(LocalDate.of(2016, Month.JANUARY, 12)),
                new Transaction(LocalDate.of(2016, Month.FEBRUARY, 3)),
                new Transaction(LocalDate.of(2016, Month.MARCH, 15)));
        transactions.stream().forEach((transaction -> account.register(transaction)));
        LocalDate start = LocalDate.of(2016, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2016, Month.APRIL, 1);
        List<Transaction> transactions1 = account.historyBetween(start, end);
        List<Transaction> transactions2 = account.historyBetween(start, LocalDate.of(2016, Month.FEBRUARY, 2));
        Assert.assertEquals(transactions1, transactions2);
        Assert.assertArrayEquals(transactions1.toArray(), transactions2.toArray());
    }

    @After
    public void cleanUpTransactions() {
    }

    @AfterClass
    public static void closeConnection() {
    }
}

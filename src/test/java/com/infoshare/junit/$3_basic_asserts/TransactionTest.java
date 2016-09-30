package com.infoshare.junit.$3_basic_asserts;

import com.infoshare.junit.$2_test_fixture.TestTransactions;
import com.infoshare.junit.$2_test_fixture.TransactionsBuilder;
import com.infoshare.junit.banking.Account;
import com.infoshare.junit.banking.Transaction;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TransactionTest {

    private static final int TRANSACTION_COUNT = 100;

    private static Account account;

    @BeforeClass
    public static void setUp() throws Exception {
        account = new Account("Kent Beck");
        new TransactionsBuilder()
                .after(LocalDateTime.of(2015, Month.DECEMBER, 1, 0, 0))
                .before(LocalDateTime.of(2016, Month.APRIL, 30, 0, 0))
                .valueBetween(1,100000)
                .totalOf(TRANSACTION_COUNT)
                .register(account);
    }

    @Test
    public void account_should_change_history_after_adding_transaction() throws Exception {
        //given
        Set<Transaction> originalHistory = account.history();
        //when
        new TransactionsBuilder().valueBetween(100,1000).totalOf(1).register(account);
        // then
        assertArrayEquals(originalHistory.toArray(), account.history().toArray());
    }

    @Test
    public void test_assert_same(){
        Set<Transaction> historyOne = account.history();
        Set<Transaction> historyTwo = account.history();
        assertSame(historyOne, historyTwo);
    }

    @Test
    public void compare_history_arrays() {
        Transaction[] historyOne = account.history().toArray(new Transaction[]{});
        Transaction[] historyTwo = account.history().toArray(new Transaction[]{});
        Arrays.fill(historyTwo, new Transaction(BigDecimal.TEN,LocalDateTime.now()));
        assertArrayEquals(historyOne,historyTwo);
    }

    @Test
    public void new_account_should_have_empty_history() {
        Account emptyAccount = new Account("Erich Gamma");
        assertEquals(emptyAccount.history().toArray(), new Transaction[]{});
    }

    @Test
    public void new_account_should_not_have_any_transactions_1() {
        Account emptyAccount = new Account("Erich Gamma");
        assertSame(emptyAccount.history(), new HashSet<Transaction>());
    }

    @Test
    public void new_account_should_not_have_any_transactions_2() {
        Account emptyAccount = new Account("Erich Gamma");
        assertNotNull(emptyAccount.history());
    }

    @Test
    public void new_account_should_not_have_any_transactions_3() {
        Account emptyAccount = new Account("Erich Gamma");
        assertTrue(emptyAccount.history().size()==0);
    }

}


package com.infoshare.junit.banking;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {

    private final BigDecimal amount = BigDecimal.ZERO;
    private final LocalDate date;

    public Transaction(BigDecimal initialAmount, LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

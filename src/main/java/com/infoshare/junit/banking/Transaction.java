package com.infoshare.junit.banking;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {

    private final BigDecimal amount = BigDecimal.ZERO;
    private final LocalDateTime date;

    public Transaction(BigDecimal initialAmount, LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

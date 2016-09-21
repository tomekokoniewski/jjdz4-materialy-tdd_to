package com.infoshare.junit.banking;

import java.time.LocalDate;

public class Transaction {
    private final LocalDate date;

    public Transaction(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}

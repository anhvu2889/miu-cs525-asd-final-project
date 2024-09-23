package domain.framework.entity;

import java.time.LocalDate;

public class AccountEntry {
    private final double amount;
    private final LocalDate date;
    private final TransactionType transactionType;

    public AccountEntry(double amount, TransactionType transactionType) {
        super();
        this.date = LocalDate.now();
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

}

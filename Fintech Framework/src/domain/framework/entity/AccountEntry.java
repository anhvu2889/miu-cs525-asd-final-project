package domain.framework.entity;

import java.time.LocalDate;

public class AccountEntry {
    private final double amount;
    private final LocalDate date;
    private final String description;
    private final TransactionType transactionType;

    public AccountEntry(double amount, String description, TransactionType transactionType) {
        this.date = LocalDate.now();
        this.amount = amount;
        this.description = description;
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

}

package domain.framework.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class AccountEntry {
    private final double amount;
    private final LocalDate date;
    private final String description;
    private final TransactionType transactionType;

    @JsonCreator
    public AccountEntry(@JsonProperty("amount") double amount,
                        @JsonProperty("description") String description,
                        @JsonProperty("transactionType") TransactionType transactionType) {
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

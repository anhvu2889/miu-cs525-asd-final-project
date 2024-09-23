package domain.framework.entity;

import java.time.LocalDate;

public class AccountEntry {
    private final double amount;
    private final LocalDate date;
    private final String description;

    public AccountEntry(double amount, String description) {
        super();
        this.date = LocalDate.now();
        this.amount = amount;
        this.description = description;
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

}

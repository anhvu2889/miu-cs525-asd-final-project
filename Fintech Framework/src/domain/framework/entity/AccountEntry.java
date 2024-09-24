package domain.framework.entity;

import java.time.LocalDate;

public class AccountEntry {
    private final double amount;
    private final LocalDate date;
    private final String description;
    private Event event;

    public AccountEntry(double amount, String description, Event event) {
        this.date = LocalDate.now();
        this.amount = amount;
        this.description = description;
        this.event = event;
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

    public Event getEvent() {
        return event;
    }
}

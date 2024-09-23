package domain.framework.entity;

import domain.framework.usecase.operation.interest.InterestCalculator;

import java.util.ArrayList;
import java.util.List;

public abstract class Account implements InterestCalculator {
    private final String number;
    private final Customer customer;
    private final List<AccountEntry> entries = new ArrayList<>();

    public Account(String number, Customer customer) {
        this.number = number;
        this.customer = customer;
    }

    public String getNumber() {
        return number;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<AccountEntry> getEntries() {
        return entries;
    }
    public void addEntry(AccountEntry entry) {
        entries.add(entry);
    }

    public double getBalance() {
        double balance = 0;
        for (AccountEntry entry : entries) {
            balance += entry.getAmount();
        }
        return balance;
    }

    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(amount, "deposit");
        entries.add(entry);
    }

    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(-amount, "withdraw");
        entries.add(entry);
    }

    public void addInterest(double amount) {
        AccountEntry entry = new AccountEntry(amount, "interest");
        entries.add(entry);
    }


}

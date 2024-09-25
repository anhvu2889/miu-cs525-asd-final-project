package domain.framework.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
    private final String number;
    private final Customer customer;
    private final List<AccountEntry> entries = new ArrayList<>();
    private InterestCalculatorStrategy interestCalculatorStrategy;

    @JsonCreator
    public Account(@JsonProperty("number") String number,
                   @JsonProperty("customer") Customer customer) {
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

    public void deposit(double amount, String description) {
        AccountEntry entry = new AccountEntry(amount, description, TransactionType.DEPOSIT);
        entries.add(entry);
    }

    public void withdraw(double amount, String description) {
        AccountEntry entry = new AccountEntry(-amount, description, TransactionType.WITHDRAWAL);
        entries.add(entry);
    }

    public void addInterest() {
        double interest = this.interestCalculatorStrategy.calculateInterest(getBalance());
        AccountEntry entry = this.createEntry(interest, "interest", TransactionType.ADD_INTEREST);
        this.addEntry(entry);
    }

    public void setInterestCalculator(InterestCalculatorStrategy interestCalculatorStrategy) {
        this.interestCalculatorStrategy = interestCalculatorStrategy;
    }

    public AccountEntry createEntry(double amount, String description, TransactionType event) {
        return new AccountEntry(amount, description, event);
    }
}

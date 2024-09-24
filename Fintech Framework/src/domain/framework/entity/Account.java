package domain.framework.entity;

import com.fasterxml.jackson.annotation.*;
import domain.banking.entity.CheckingAccountStrategy;
import domain.banking.entity.CompanyAccount;
import domain.banking.entity.PersonalAccount;
import domain.banking.entity.SavingAccount;
import domain.framework.usecase.operation.interest.InterestCalculator;

import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,  // Use the "type" field in JSON to identify the subclass
        include = JsonTypeInfo.As.PROPERTY,  // Include it as a property in the JSON
        property = "personal"  // The JSON field that tells us which subclass to use
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PersonalAccount.class, name = "personal")
})
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Account implements InterestCalculator {
    private final String number;
    private final Customer customer;
    private final List<AccountEntry> entries = new ArrayList<>();

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

    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(amount, TransactionType.DEPOSIT);
        entries.add(entry);
    }

    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(-amount, TransactionType.WITHDRAWAL);
        entries.add(entry);
    }

    public void addInterest(double amount) {
        AccountEntry entry = new AccountEntry(amount, TransactionType.ADD_INTEREST);
        entries.add(entry);
    }


}

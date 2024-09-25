package domain.banking.entity;

import domain.framework.entity.Account;
import domain.framework.entity.AccountEntry;
import domain.framework.entity.AccountReport;
import domain.framework.entity.TransactionType;

import java.time.LocalDate;

public class BankingAccountReport extends AccountReport {

    private double amount;
    private TransactionType transactionType;
    private String description;
    private LocalDate dateAction;

    public BankingAccountReport(Account account, AccountEntry accountEntry) {
        super(account);
        this.amount = accountEntry.getAmount();
        this.transactionType = accountEntry.getTransactionType();
        this.description = accountEntry.getDescription();
        this.dateAction = accountEntry.getDate();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateAction() {
        return dateAction;
    }

    public void setDateAction(LocalDate dateAction) {
        this.dateAction = dateAction;
    }

    @Override
    public String toString() {
        return "Customer Name= " + getCustomerName() +
                "\nCustomer Email= " + getCustomerEmail() +
                "\nCustomer Address= " + getCustomerAddress() +
                "\nAccount Number= " + getAccountNumber() +
                "\nTransaction Type=" + transactionType +
                "\nAmount=" + amount +
                "\nDate Action=" + dateAction +
                "\nDescription=" + description;
    }
}

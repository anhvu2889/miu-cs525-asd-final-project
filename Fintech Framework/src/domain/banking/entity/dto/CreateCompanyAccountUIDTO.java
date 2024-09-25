package domain.banking.entity.dto;

import domain.banking.entity.accounts.AccountType;
import domain.framework.entity.Customer;

public class CreateCompanyAccountUIDTO {
    private String accountNumber;
    private Customer customer;
    private AccountType accountType;

    public CreateCompanyAccountUIDTO(String accountNumber, Customer customer, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}

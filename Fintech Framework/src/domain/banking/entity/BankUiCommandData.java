package domain.banking.entity;

import domain.banking.entity.accounts.AccountType;
import domain.framework.entity.Customer;

public record BankUiCommandData(String accountNumber, Customer customer, AccountType accountType, double amount) {
}

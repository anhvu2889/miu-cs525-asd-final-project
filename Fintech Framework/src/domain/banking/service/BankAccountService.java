package domain.banking.service;

import domain.framework.entity.Account;
import domain.framework.entity.Customer;
import domain.framework.usecase.management.AccountFactory;

import java.util.Collection;

public interface BankAccountService {
    void createAccount(String accountNumber, Customer customer, AccountFactory accountFactory) throws Exception;

    void deposit(String accountNumber, double amount) throws Exception;

    void withdraw(String accountNumber, double amount) throws Exception;

    void addInterest();

    Collection<Account> getAccounts() throws Exception;
}

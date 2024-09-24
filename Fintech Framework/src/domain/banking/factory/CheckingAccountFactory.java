package domain.banking.factory;

import domain.banking.entity.accounts.CheckingAccount;
import domain.framework.entity.Account;
import domain.framework.entity.Customer;
import domain.framework.usecase.management.AccountFactory;

public class CheckingAccountFactory implements AccountFactory {
    @Override
    public Account createAccount(String accountNumber, Customer customer) {
        return new CheckingAccount(accountNumber, customer);
    }
}

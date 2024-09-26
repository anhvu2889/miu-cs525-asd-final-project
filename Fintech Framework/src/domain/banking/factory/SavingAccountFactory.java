package domain.banking.factory;

import domain.banking.entity.accounts.SavingAccount;
import domain.framework.entity.Account;
import domain.framework.entity.Customer;
import domain.framework.factory.AccountFactory;

public class SavingAccountFactory implements AccountFactory {
    @Override
    public Account createAccount(String accountNumber, Customer customer) {
        return new SavingAccount(accountNumber, customer);
    }
}

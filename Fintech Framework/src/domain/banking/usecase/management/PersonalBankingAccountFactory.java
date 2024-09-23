package domain.banking.usecase.management;

import domain.banking.entity.PersonalAccount;
import domain.framework.entity.Account;
import domain.framework.entity.Customer;
import domain.framework.usecase.management.AccountFactory;

public class PersonalBankingAccountFactory implements AccountFactory {
    @Override
    public Account createAccount(String accountNumber, Customer customer) {
        return new PersonalAccount(accountNumber, customer);
    }
}

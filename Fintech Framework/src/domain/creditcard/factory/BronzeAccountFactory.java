package domain.creditcard.factory;

import domain.framework.entity.Account;
import domain.framework.entity.Customer;
import domain.framework.usecase.management.AccountFactory;

public class BronzeAccountFactory implements AccountFactory {
    @Override
    public Account createAccount(String accountNumber, Customer customer) {
        return null;
    }
}

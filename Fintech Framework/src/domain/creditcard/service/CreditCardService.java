package domain.creditcard.service;

import domain.creditcard.entity.CreditAccount;
import domain.creditcard.usecase.interest.abstractfactory.CreditCardFactory;
import domain.framework.entity.Account;

import java.util.Collection;

public interface CreditCardService {
    void createCreditAccount(CreditCardFactory factory) throws Exception;

    void deposit(String accountNumber, double amount, String description) throws Exception;

    void charge(String accountNumber, double amount, String description) throws Exception;

    CreditAccount loadAccount(String accountNumber) throws Exception;

    Collection<Account> getAccounts() throws Exception;
}

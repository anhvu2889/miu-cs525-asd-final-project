package domain.creditcard.service;

import domain.creditcard.dto.BillReportUiDTO;
import domain.creditcard.entity.CreditAccount;
import domain.creditcard.factory.CreditCardFactory;
import domain.framework.entity.Account;

import java.util.Collection;

public interface CreditCardService {
    void createCreditAccount(CreditCardFactory factory) throws Exception;

    void deposit(String accountNumber, double amount, String description) throws Exception;

    void charge(String accountNumber, double amount, String description) throws Exception;

    CreditAccount loadAccount(String accountNumber) throws Exception;

    Collection<Account> getAccounts() throws Exception;

    void generateMonthlyReport(BillReportUiDTO billReportUiDTO) throws Exception;
}

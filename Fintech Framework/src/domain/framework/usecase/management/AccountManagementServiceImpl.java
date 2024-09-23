package domain.framework.usecase.management;

import domain.framework.entity.Account;
import domain.framework.entity.Customer;
import driver.repository.AccountRepository;

public class AccountManagementServiceImpl implements AccountManagementService {
    private AccountRepository accountRepository;
    private AccountFactory accountFactory;

    public AccountManagementServiceImpl(AccountRepository accountRepository, AccountFactory accountFactory) {
        this.accountRepository = accountRepository;
        this.accountFactory = accountFactory;
    }

    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void setAccountFactory(AccountFactory accountFactory) {
        this.accountFactory = accountFactory;
    }

    @Override
    public Account createAccount(String accountNumber, Customer customer) {
        Account account = accountFactory.createAccount(accountNumber, customer);
        accountRepository.save(account);
        return account;
    }
}

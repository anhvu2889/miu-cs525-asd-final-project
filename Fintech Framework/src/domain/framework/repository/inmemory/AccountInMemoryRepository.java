package domain.framework.repository.inmemory;

import domain.framework.entity.Account;
import domain.framework.repository.AccountRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountInMemoryRepository implements AccountRepository {

    private static AccountInMemoryRepository instance = new AccountInMemoryRepository();

    public static AccountInMemoryRepository getInstance() {
        return AccountInMemoryRepository.instance;
    }

    private AccountInMemoryRepository() {

    }

    private List<Account> accounts = new ArrayList<>();

    @Override
    public void save(Account account) {
        accounts.add(account);
    }

    @Override
    public void update(Account account) {
        int index = accounts.indexOf(account);
        accounts.set(index, account);
    }

    @Override
    public void delete(Account account) {

    }

    @Override
    public Account getAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accounts;
    }

    @Override
    public boolean isNotExist(String accountNumber) {
        return getAccount(accountNumber) == null;
    }
}

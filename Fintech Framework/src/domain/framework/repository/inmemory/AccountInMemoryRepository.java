package domain.framework.repository.inmemory;

import domain.framework.database.DatabaseService;
import domain.framework.database.DatabaseServiceImpl;
import domain.framework.entity.Account;
import domain.framework.repository.AccountRepository;

import java.util.Collection;
import java.util.List;

public class AccountInMemoryRepository implements AccountRepository {

    private static AccountInMemoryRepository instance = new AccountInMemoryRepository();

    public static AccountInMemoryRepository getInstance() {
        return AccountInMemoryRepository.instance;
    }

    private List<Account> accounts;

    private DatabaseService databaseService;

    private AccountInMemoryRepository() {
        databaseService = new DatabaseServiceImpl();
        accounts = databaseService.loadFromDB();
    }

    @Override
    public void save(Account account) {
        accounts.add(account);
        databaseService.saveToDB(accounts);
    }

    @Override
    public void update(Account account) {
        int index = accounts.indexOf(account);
        accounts.set(index, account);
        databaseService.saveToDB(accounts);
    }

    @Override
    public void delete(Account account) {
        if (accounts.remove(account)) {
            databaseService.saveToDB(accounts);
            System.out.println("Account with number " + account.getNumber() + " has been deleted.");
        } else {
            System.out.println("Account with number " + account.getNumber() + " was not found.");
        }
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

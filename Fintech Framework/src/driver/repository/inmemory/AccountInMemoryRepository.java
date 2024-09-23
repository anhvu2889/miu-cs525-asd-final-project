package driver.repository.inmemory;

import domain.framework.entity.Account;
import driver.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

public class AccountInMemoryRepository  implements AccountRepository {
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
    public Account findByUsername(String username) {
        return null;
    }
}

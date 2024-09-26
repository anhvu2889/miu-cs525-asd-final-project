package domain.framework.repository;

import domain.framework.entity.Account;

import java.util.Collection;

public interface AccountRepository {
    void save(Account account);
    void update(Account account);
    void delete(Account account);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    boolean isNotExist(String accountNumber);
}

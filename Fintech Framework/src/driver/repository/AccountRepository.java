package driver.repository;

import domain.framework.entity.Account;

public interface AccountRepository {
    void save(Account account);
    void update(Account account);
    void delete(Account account);
    Account findByUsername(String username);
}

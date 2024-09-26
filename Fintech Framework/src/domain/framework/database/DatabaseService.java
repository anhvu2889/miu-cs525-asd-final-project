package domain.framework.database;

import domain.framework.entity.Account;

import java.util.List;

public interface DatabaseService {
    void saveToDB(List<Account> accounts);
    List<Account> loadFromDB();
}

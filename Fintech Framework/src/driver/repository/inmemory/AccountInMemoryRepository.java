package driver.repository.inmemory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import domain.framework.entity.Account;
import driver.repository.AccountRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountInMemoryRepository implements AccountRepository {

    private static AccountInMemoryRepository instance = new AccountInMemoryRepository();

    public static AccountInMemoryRepository getInstance() {
        return AccountInMemoryRepository.instance;
    }

    private static final String FILE_PATH = "Fintech Framework/src/database/accounts.json";
    private final ObjectMapper objectMapper;
    private final File file;

    private AccountInMemoryRepository() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        file = new File(FILE_PATH);
        loadFromFile();
    }

    private List<Account> accounts = new ArrayList<>();

    @Override
    public void save(Account account) {
        accounts.add(account);
        saveToFile();
        System.out.println("Saved account: " + account.getNumber());
    }

    @Override
    public void update(Account account) {
        int index = accounts.indexOf(account);
        accounts.set(index, account);
        saveToFile();
    }

    @Override
    public void delete(Account account) {
        if (accounts.remove(account)) {
            saveToFile();
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

    private void loadFromFile() {
        if (file.exists() && file.length() > 0) {
            try {
                accounts = objectMapper.readValue(file, new TypeReference<>() {
                });
                System.out.println("Loaded accounts from Database");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void saveToFile() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, accounts);
            System.out.println("Saved accounts to Database");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

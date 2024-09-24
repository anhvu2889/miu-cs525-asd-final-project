package driver.repository.inmemory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import domain.framework.entity.Account;
import driver.repository.AccountRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountInMemoryRepository  implements AccountRepository {
    private List<Account> accounts = new ArrayList<>();

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File file = new File("accounts.json");

    public AccountInMemoryRepository() {
        objectMapper.registerModule(new JavaTimeModule());
        loadFromFile();
    }

    @Override
    public void save(Account account) {
        accounts.add(account);
        saveToFile();
    }

    @Override
    public void update(Account account) {
        int index = accounts.indexOf(account);
        if (index >= 0) {
            accounts.set(index, account);
            saveToFile();
        }
    }

    @Override
    public void delete(Account account) {
        accounts.remove(account);
        saveToFile();
    }

    @Override
    public Account findByUsername(String username) {
        return accounts.stream()
                .filter(account -> account.getCustomer().getName().equals(username))
                .findFirst()
                .orElse(null);
    }

    private void saveToFile() {
        try {
            objectMapper.writeValue(file, accounts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        if (file.exists()) {
            try {
                accounts = objectMapper.readValue(file, new TypeReference<List<Account>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

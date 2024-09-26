package domain.framework.database;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import domain.framework.entity.Account;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseServiceImpl implements DatabaseService {
    private List<Account> accounts = new ArrayList<>();
    private final ObjectMapper objectMapper;
    private final File file;

    public DatabaseServiceImpl() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        file = new File("accounts.json");
    }

    @Override
    public void saveToDB(List<Account> accounts) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, accounts);
            System.out.println("Saved accounts to Database");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Account> loadFromDB() {
        if (file.exists() && file.length() > 0) {
            try {
                accounts = objectMapper.readValue(file, new TypeReference<>() {});
                System.out.println("Loaded accounts from Database");
                return accounts;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
}

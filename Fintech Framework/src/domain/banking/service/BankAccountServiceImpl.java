package domain.banking.service;

import domain.banking.entity.BankingAccountReport;
import domain.framework.entity.Account;
import domain.framework.entity.AccountEntry;
import domain.framework.entity.Customer;
import domain.framework.entity.TransactionType;
import domain.framework.usecase.management.AccountFactory;
import domain.framework.usecase.notification.subject.NotifySubject;
import domain.framework.usecase.operation.AccountOperationServiceImpl;
import domain.framework.utils.BankHelper;
import driver.repository.inmemory.AccountInMemoryRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class BankAccountServiceImpl implements BankAccountService {
    private final AccountOperationServiceImpl<Account, AccountEntry> accountOperationService;
    private static BankAccountServiceImpl instance = new BankAccountServiceImpl();

    public static BankAccountServiceImpl getInstance() {
        return BankAccountServiceImpl.instance;
    }

    private BankAccountServiceImpl() {
        this.accountOperationService = new AccountOperationServiceImpl<>(
                AccountInMemoryRepository.getInstance(),
                BankHelper.getRuleEngine(),
                new NotifySubject(),
                new ArrayList<>()
        );
    }

    public void createAccount(String accountNumber, Customer customer, AccountFactory accountFactory) throws Exception {
        if (accountOperationService.getRepository().isNotExist(accountNumber)) {
            Account account = accountFactory.createAccount(accountNumber, customer);
            accountOperationService.getRepository().save(account);
            return;
        }
        throw new Exception("Account with number " + accountNumber + " already exists");
    }

    public void deposit(String accountNumber, double amount) throws Exception {
        Account account = accountOperationService.getRepository().getAccount(accountNumber);
        if (account != null) {
            AccountEntry entry = account.createEntry(amount, "Amount deposit", TransactionType.DEPOSIT);
            this.accountOperationService.getRuleEngine().setRules(BankTransactionRules.getDepositRules(accountOperationService.getNotificationSubject()));
            this.accountOperationService.deposit(account, entry);
            return;
        }
        throw new Exception("Account with number " + accountNumber + " does not exist");
    }

    public void withdraw(String accountNumber, double amount) throws Exception {
        Account account = accountOperationService.getRepository().getAccount(accountNumber);
        if (account != null) {
            AccountEntry entry = account.createEntry(amount, "Amount withdraw", TransactionType.WITHDRAWAL);
            this.accountOperationService.getRuleEngine().setRules(BankTransactionRules.getWithdrawRules(accountOperationService.getNotificationSubject()));
            this.accountOperationService.withdraw(account, entry);
            return;
        }
        throw new Exception("Account with number " + accountNumber + " does not exist");
    }

    public void addInterest() {
        this.accountOperationService.addInterest();
    }

    public Collection<Account> getAccounts() throws Exception {
        return accountOperationService.getRepository().getAllAccounts();
    }

    public List<BankingAccountReport> reportAccountHistory(String accountNumber, LocalDate startDate, LocalDate endDate) throws Exception {
        Account account = accountOperationService.getRepository().getAccount(accountNumber);
        if (account != null) {
            return account.getEntries()
                    .stream()
                    .filter(entry -> (entry.getDate().isAfter(startDate) || entry.getDate().isEqual(startDate))
                            && (entry.getDate().isBefore(endDate) || entry.getDate().isEqual(endDate)))
                    .map(entry -> new BankingAccountReport(account, entry))
                    .collect(Collectors.toList());
        }
        throw new Exception("Account with number " + accountNumber + " does not exist");
    }
}

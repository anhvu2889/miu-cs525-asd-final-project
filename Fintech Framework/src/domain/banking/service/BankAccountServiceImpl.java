package domain.banking.service;

import domain.banking.entity.BankingAccountReport;
import domain.banking.entity.dto.BankReportUiDTO;
import domain.banking.rules.BankTransactionRules;
import domain.framework.entity.Account;
import domain.framework.entity.AccountEntry;
import domain.framework.entity.Customer;
import domain.framework.entity.TransactionType;
import domain.framework.usecase.management.AccountFactory;
import domain.framework.usecase.notification.subject.NotifySubject;
import domain.framework.usecase.operation.AccountOperationServiceImpl;
import domain.framework.utils.BankHelper;
import driver.repository.inmemory.AccountInMemoryRepository;

import java.util.ArrayList;
import java.util.Collection;
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

    public void reportAccountHistory(BankReportUiDTO bankReportUiDTO) throws Exception {
        Account account = accountOperationService.getRepository().getAccount(bankReportUiDTO.getAccountNUmber());
        if (account != null) {
            List<BankingAccountReport> reports = account.getEntries()
                    .stream()
                    .filter(entry -> (entry.getDate().isAfter(bankReportUiDTO.getStartDate()) || entry.getDate().isEqual(bankReportUiDTO.getStartDate()))
                            && (entry.getDate().isBefore(bankReportUiDTO.getEndDate()) || entry.getDate().isEqual(bankReportUiDTO.getEndDate())))
                    .map(entry -> new BankingAccountReport(account, entry))
                    .collect(Collectors.toList());

            bankReportUiDTO.setAllAccountsReport(convertBankingAccountReportToString(reports));
            return;
        }
        throw new Exception("Account with number " + bankReportUiDTO.getAccountNUmber() + " does not exist");
    }

    private String convertBankingAccountReportToString(List<BankingAccountReport> reports) {
        StringBuilder result = new StringBuilder();
        reports.forEach(r -> {
            result.append(r.toString()).append("\n\n");
        });
        return result.toString();
    }
}

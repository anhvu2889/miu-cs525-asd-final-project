package domain.banking;

import domain.framework.entity.*;
import domain.framework.usecase.management.AccountFactory;
import domain.framework.usecase.notification.subject.NotifySubject;
import domain.framework.usecase.operation.AccountOperationServiceImpl;
import domain.framework.utils.BankHelper;
import driver.repository.inmemory.AccountInMemoryRepository;

public class BankService {
    private final AccountOperationServiceImpl<Account, AccountEntry> accountOperationService;
    private static BankService instance = new BankService();

    public static BankService getInstance() {
        return BankService.instance;
    }

    private BankService() {
        this.accountOperationService = new AccountOperationServiceImpl<>(
                AccountInMemoryRepository.getInstance(),
                BankHelper.getRuleEngine(),
                new NotifySubject()
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
            this.accountOperationService.getRuleEngine().setRules(BankHelper.getDepositRules(accountOperationService.getNotificationSubject()));
            this.accountOperationService.deposit(account, entry);
            return;
        }
        throw new Exception("Account with number " + accountNumber + " does not exist");
    }

    public void withdraw(String accountNumber, double amount) throws Exception {
        Account account = accountOperationService.getRepository().getAccount(accountNumber);
        if (account != null) {
            AccountEntry entry = account.createEntry(amount, "Amount withdraw", TransactionType.WITHDRAWAL);
            this.accountOperationService.getRuleEngine().setRules(BankHelper.getWithdrawRules(accountOperationService.getNotificationSubject()));
            this.accountOperationService.withdraw(account, entry);
            return;
        }
        throw new Exception("Account with number " + accountNumber + " does not exist");
    }

    public void addInterest() {
        this.accountOperationService.addInterest();
    }

    public Account getAccount(String number) {
        return accountOperationService.getRepository().getAccount(number);
    }
}

package domain.creditcard.service;

import domain.creditcard.dto.BillReportUiDTO;
import domain.creditcard.entity.CreditAccount;
import domain.creditcard.entity.CreditAccountReport;
import domain.creditcard.usecase.interest.abstractfactory.CreditCardFactory;
import domain.framework.entity.Account;
import domain.framework.entity.AccountEntry;
import domain.framework.entity.TransactionType;
import domain.framework.usecase.notification.subject.NotifySubject;
import domain.framework.usecase.operation.AccountOperationServiceImpl;
import domain.framework.utils.BankHelper;
import driver.repository.inmemory.AccountInMemoryRepository;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CreditCardServiceImpl implements CreditCardService {
    private final AccountOperationServiceImpl<Account, AccountEntry> accountOperationService;
    private static CreditCardServiceImpl instance = new CreditCardServiceImpl();

    public static CreditCardServiceImpl getInstance() {
        return CreditCardServiceImpl.instance;
    }

    private CreditCardServiceImpl() {
        this.accountOperationService = new AccountOperationServiceImpl<>(
                AccountInMemoryRepository.getInstance(),
                BankHelper.getRuleEngine(),
                new NotifySubject(),
                new ArrayList<>()
        );
    }

    public void createCreditAccount(CreditCardFactory factory) throws Exception {
        if (accountOperationService.getRepository().isNotExist(factory.getAccountNumber())) {
            Account account = factory.createCreditAccount();
            accountOperationService.getRepository().save(account);
            return;
        }
        throw new Exception("Account with number " + factory.getAccountNumber() + " already exists");
    }

    public void deposit(String accountNumber, double amount, String description) throws Exception {
        Account account = accountOperationService.getRepository().getAccount(accountNumber);
        account.withdraw(amount, description);
        accountOperationService.getRepository().update(account);
    }

    public void charge(String accountNumber, double amount, String description) throws Exception {
        Account account = accountOperationService.getRepository().getAccount(accountNumber);
        if (amount > 400) {
            accountOperationService.getNotificationSubject().notifyObservers(TransactionType.WITHDRAWAL, account);
        }
        account.deposit(amount, description);
        accountOperationService.getRepository().update(account);
    }

    public CreditAccount loadAccount(String accountNumber) throws Exception {
        Account account = accountOperationService.getRepository().getAccount(accountNumber);

        if (account != null) {
            return (CreditAccount) account;
        }
        throw new Exception("Account with number " + accountNumber + " does not exist");
    }

    public Collection<Account> getAccounts() throws Exception {
        return accountOperationService.getRepository().getAllAccounts();
    }

    public void generateMonthlyReport(BillReportUiDTO billReportUiDTO) throws Exception {
        CreditAccount account = (CreditAccount) accountOperationService.getRepository().getAccount(billReportUiDTO.getAccountNUmber());
        if (account != null) {
            double previousBalance = getPreviousBalance(account);
            double totalCharges = getTotalCharges(account);
            double totalCredits = getTotalCredits(account);
            double newBalance = getNewBalance(account);
            double totalDue = account.getMinimumPaymentStrategy().calculateMinimumPayment(newBalance);

            CreditAccountReport creditAccountReport = new CreditAccountReport(account, previousBalance, totalCharges, totalCredits, newBalance, totalDue);
            billReportUiDTO.setMonthlyBillReport(creditAccountReport.toString());
            return;
        }
        throw new Exception("Account with number " + billReportUiDTO.getAccountNUmber() + " does not exist");
    }

    private double getPreviousBalance(Account account) {
        LocalDate firstDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        return account.getEntries()
                .stream()
                .filter(entry -> !TransactionType.ADD_INTEREST.equals(entry.getTransactionType()))
                .filter(entry -> entry.getDate().isBefore(firstDate))
                .mapToDouble(AccountEntry::getAmount)
                .sum();
    }

    private double getNewBalance(Account account) {
        double balanceAfterCredits = getPreviousBalance(account) - getTotalCredits(account);
        return balanceAfterCredits + getTotalCharges(account) + account.getInterestCalculatorStrategy().calculateInterest(balanceAfterCredits);
    }

    private double getTotalCharges(Account account) {
        return this.getAccountEntryByTransactionTypeAndMonth(account, TransactionType.WITHDRAWAL, LocalDate.now())
                .stream()
                .mapToDouble(AccountEntry::getAmount)
                .sum();
    }

    private double getTotalCredits(Account account) {
        return this.getAccountEntryByTransactionTypeAndMonth(account, TransactionType.DEPOSIT, LocalDate.now())
                .stream()
                .mapToDouble(AccountEntry::getAmount)
                .sum();
    }

    private List<AccountEntry> getAccountEntryByTransactionTypeAndMonth(Account account, TransactionType transactionType, LocalDate date) {
        if (date == null) {
            date = LocalDate.now();
        }

        LocalDate startDate = date.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate endDate = date.with(TemporalAdjusters.lastDayOfMonth());

        return account.getEntries()
                .stream()
                .filter(entry -> transactionType.equals(entry.getTransactionType()))
                .filter(entry -> (entry.getDate().isAfter(startDate) || entry.getDate().isEqual(startDate))
                        && (entry.getDate().isBefore(endDate) || entry.getDate().isEqual(endDate)))
                .collect(Collectors.toList());
    }
}

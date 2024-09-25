package domain.creditcard;

import domain.creditcard.entity.CreditAccount;
import domain.creditcard.usecase.interest.abstractfactory.CreditCardFactory;
import domain.framework.entity.Account;
import domain.framework.entity.AccountEntry;
import domain.framework.usecase.notification.subject.NotifySubject;
import domain.framework.usecase.operation.AccountOperationServiceImpl;
import domain.framework.utils.BankHelper;
import driver.repository.inmemory.AccountInMemoryRepository;

import java.util.Collection;

public class CreditCardService {
    private final AccountOperationServiceImpl<Account, AccountEntry> accountOperationService;
    private static CreditCardService instance = new CreditCardService();

    public static CreditCardService getInstance() {
        return CreditCardService.instance;
    }

    private CreditCardService() {
        this.accountOperationService = new AccountOperationServiceImpl<>(
                AccountInMemoryRepository.getInstance(),
                BankHelper.getRuleEngine(),
                new NotifySubject()
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

    public CreditAccount loadAccount(String accountNumber) throws Exception {
        Account account = accountOperationService.getRepository().getAccount(accountNumber);

        if (account != null) {
            return (CreditAccount) account;
        }
        throw new Exception("Account with number " + accountNumber + " does not exist");
    }
}

import domain.banking.usecase.management.PersonalBankingAccountFactory;
import domain.banking.usecase.management.operation.PersonalBankingAccountOperationService;
import domain.framework.entity.Account;
import domain.framework.usecase.management.AccountFactory;
import domain.framework.usecase.management.AccountManagementService;
import domain.framework.usecase.management.AccountManagementServiceImpl;
import domain.framework.usecase.operation.AccountOperationService;
import driver.repository.AccountRepository;
import driver.repository.inmemory.AccountInMemoryRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AccountRepository accountRepository = new AccountInMemoryRepository();
        AccountFactory accountFactory = new PersonalBankingAccountFactory();
        AccountManagementService accountManagementService = new AccountManagementServiceImpl(accountRepository, accountFactory);
        Account personalAccount = accountManagementService.createAccount("123456", null);
        System.out.println(personalAccount.getNumber());
        AccountOperationService accountOperationService = new PersonalBankingAccountOperationService(personalAccount);
        accountOperationService.deposit(300);
        accountOperationService.withdraw(1000);
    }
}
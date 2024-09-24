import domain.banking.BankService;
import domain.banking.entity.BankUiCommandData;
import domain.banking.entity.accounts.AccountType;
import domain.banking.entity.customers.Company;
import domain.banking.entity.customers.Person;
import domain.banking.usecase.AddInterestUsecase;
import domain.banking.usecase.CreateAccountUsecase;
import domain.banking.usecase.DepositAccountUsecase;
import domain.banking.usecase.WithdrawAccountUsecase;
import domain.framework.entity.Customer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        AccountRepository accountRepository = new AccountInMemoryRepository();
//        AccountFactory accountFactory = new PersonalBankingAccountFactory();
//        AccountManagementService accountManagementService = new AccountManagementServiceImpl(accountRepository, accountFactory);
//        Account personalAccount = accountManagementService.createAccount("123456", null);
//        System.out.println(personalAccount.getNumber());
//        AccountOperationService accountOperationService = new PersonalBankingAccountOperationService(personalAccount);
//        accountOperationService.deposit("111", 300);
//        accountOperationService.withdraw("111", 1000);
        CreateAccountUsecase createAccountUsecase = new CreateAccountUsecase(BankService.getInstance());
        CreateAccountUsecase createLoanAccountUsecase = new CreateAccountUsecase(BankService.getInstance());
        try {
            createAccountUsecase.execute(new BankUiCommandData("111", new Company("Duy", "", null, 9), AccountType.CHECKING, 0.0));
            System.out.println(BankService.getInstance().getAccount("111").getCustomer().getName());

            createLoanAccountUsecase.execute(new BankUiCommandData("222", new Company("Vu", "", null, 9), AccountType.LOAN, 0.0));
            System.out.println(BankService.getInstance().getAccount("222").getCustomer().getName());
        } catch (Exception e) {
            // show dialog : e.message
        }

        //Deposit
        DepositAccountUsecase depositAccountUsecase = new DepositAccountUsecase(BankService.getInstance());
        WithdrawAccountUsecase withdrawAccountUsecase = new WithdrawAccountUsecase(BankService.getInstance());
        try {
//            depositAccountUsecase.execute(new BankUiCommandData("111", new Company("Duy", "", null, 9), AccountType.CHECKING, 500.0));
//            System.out.println(BankService.getInstance().getAccount("111").getBalance());
//
//            withdrawAccountUsecase.execute(new BankUiCommandData("111", new Company("Duy", "", null, 9), AccountType.CHECKING, 100.0));
//            System.out.println(BankService.getInstance().getAccount("111").getBalance());
//
//            AddInterestUsecase addInterestUsecase = new AddInterestUsecase(BankService.getInstance());
//            addInterestUsecase.execute(null);
//            System.out.println(BankService.getInstance().getAccount("111").getBalance());


            depositAccountUsecase.execute(new BankUiCommandData("222", new Company("Duy", "", null, 9), AccountType.LOAN, 500.0));
            System.out.println(BankService.getInstance().getAccount("222").getBalance());
            withdrawAccountUsecase.execute(new BankUiCommandData("222", new Company("Vu", "", null, 9), AccountType.CHECKING, 100.0));
            System.out.println(BankService.getInstance().getAccount("222").getBalance());

            AddInterestUsecase addInterestUsecase = new AddInterestUsecase(BankService.getInstance());
            addInterestUsecase.execute(null);
            System.out.println(BankService.getInstance().getAccount("222").getBalance());

            addInterestUsecase.execute(null);
            System.out.println(BankService.getInstance().getAccount("111").getBalance());
        } catch (Exception e) {
            // show dialog
        }




    }
}
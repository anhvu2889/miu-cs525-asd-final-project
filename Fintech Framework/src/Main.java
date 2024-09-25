import domain.creditcard.CreditCardService;
import domain.creditcard.entity.CreditCardType;
import domain.creditcard.entity.NewCreditAccountCommandData;
import domain.creditcard.usecase.CreateCreditAccountUsecase;
import domain.framework.entity.Customer;

import java.time.LocalDate;

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

        // Test create credit card
        CreateCreditAccountUsecase createCreditAccountUsecase = new CreateCreditAccountUsecase(CreditCardService.getInstance());
        try {
            createCreditAccountUsecase.execute(
                    new NewCreditAccountCommandData(
                            "111",
                            new Customer("Test", null, ""),
                            CreditCardType.BRONZE,
                            LocalDate.now()
                    )
            );

            createCreditAccountUsecase.execute(
                    new NewCreditAccountCommandData(
                            "112",
                            new Customer("Pass", null, ""),
                            CreditCardType.GOLD,
                            LocalDate.now()
                    )
            );

            System.out.println(CreditCardService.getInstance().loadAccount("112").getAccountType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
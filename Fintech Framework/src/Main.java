import domain.creditcard.CreditCardService;
import domain.creditcard.dto.ChargeCreditUiDTO;
import domain.creditcard.dto.NewCreditUiDTO;
import domain.creditcard.entity.CreditCardType;
import domain.creditcard.usecase.ChargeCreditAccountUsecase;
import domain.creditcard.usecase.CreateCreditAccountUsecase;
import domain.creditcard.usecase.DepositCreditAccountUsecase;
import domain.framework.entity.Customer;
import domain.framework.ui.dto.DepositUiDTO;

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
                    new NewCreditUiDTO(
                            "111",
                            new Customer("Test", null, ""),
                            CreditCardType.BRONZE,
                            LocalDate.now()
                    )
            );

            createCreditAccountUsecase.execute(
                    new NewCreditUiDTO(
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

        // Test Deposit credit card
        DepositCreditAccountUsecase usecase = new DepositCreditAccountUsecase(CreditCardService.getInstance());
        try {
            System.out.println("Credit Balance Before deposit: " + CreditCardService.getInstance().loadAccount("111").getBalance());
            usecase.execute(new DepositUiDTO(
                    "111", 100, "deposit"
            ));
            System.out.println("Credit Balance After deposit: " + CreditCardService.getInstance().loadAccount("111").getBalance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test Withdraw credit card
        ChargeCreditAccountUsecase chargeUsecase = new ChargeCreditAccountUsecase(CreditCardService.getInstance());
        try {
            System.out.println("Credit Balance Before charge: " + CreditCardService.getInstance().loadAccount("111").getBalance());
            chargeUsecase.execute(new ChargeCreditUiDTO(
                    "111", 100, "deposit"
            ));
            System.out.println("Credit Balance After charge: " + CreditCardService.getInstance().loadAccount("111").getBalance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
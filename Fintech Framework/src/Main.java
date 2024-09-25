import domain.banking.BankService;
import domain.banking.entity.BankUiCommandData;
import domain.banking.entity.accounts.AccountType;
import domain.banking.entity.customers.Company;
import domain.banking.entity.customers.Person;
import domain.banking.entity.dto.CreatePersonalAccountUiDTO;
import domain.banking.usecase.CreatePersonalAccountUsecase;
import domain.banking.usecase.DepositAccountUsecase;
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

         CreatePersonalAccountUsecase personalAccountUsecase = new CreatePersonalAccountUsecase(BankService.getInstance());

        //Create account 1
         try {
             personalAccountUsecase.execute(new CreatePersonalAccountUiDTO("113", new Person("Duy", "vduy@gmail.com", null, null), AccountType.CHECKING));
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }

        //Create account 2
//        try{
//            createAccountUsecase.execute(new BankUiCommandData("112", new Company("Thinh", "", null, 9), AccountType.SAVING, 0.0));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        DepositAccountUsecase depositAccountUsecase = new DepositAccountUsecase(BankService.getInstance());

         try {
             depositAccountUsecase.execute(new DepositUiDTO("113", 500, "deposit"));
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }

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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
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
            System.out.println(e.getMessage());
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
                    "111", 100, "charge"
            ));
            System.out.println("Credit Balance After charge: " + CreditCardService.getInstance().loadAccount("111").getBalance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
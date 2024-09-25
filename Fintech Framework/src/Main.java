import domain.banking.BankService;
import domain.banking.entity.BankUiCommandData;
import domain.banking.entity.accounts.AccountType;
import domain.banking.entity.customers.Company;
import domain.banking.usecase.AddInterestUsecase;
import domain.banking.usecase.CreateAccountUsecase;
import domain.banking.usecase.DepositAccountUsecase;
import domain.banking.usecase.WithdrawAccountUsecase;
import domain.creditcard.CreditCardService;
import domain.creditcard.dto.ChargeCreditAccountCommandData;
import domain.creditcard.dto.DepositCreditAccountCommandData;
import domain.creditcard.dto.NewCreditAccountCommandData;
import domain.creditcard.entity.CreditCardType;
import domain.creditcard.usecase.ChargeCreditAccountUsecase;
import domain.creditcard.usecase.CreateCreditAccountUsecase;
import domain.creditcard.usecase.DepositCreditAccountUsecase;
import domain.framework.entity.Customer;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CreateAccountUsecase createAccountUsecase = new CreateAccountUsecase(BankService.getInstance());

        //Create account 1
        try {
            createAccountUsecase.execute(new BankUiCommandData("113", new Company("Duy", "vduy@gmail.com", null, 9), AccountType.CHECKING, 0.0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Create account 2
//        try{
//            createAccountUsecase.execute(new BankUiCommandData("112", new Company("Thinh", "", null, 9), AccountType.SAVING, 0.0));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //Deposit
        DepositAccountUsecase depositAccountUsecase = new DepositAccountUsecase(BankService.getInstance());
        //Withdraw
        WithdrawAccountUsecase withdrawAccountUsecase = new WithdrawAccountUsecase(BankService.getInstance());
        try {
            depositAccountUsecase.execute(new BankUiCommandData("113", new Company("Duy", "vduy@gmail.com", null, 9), AccountType.CHECKING, 500.0));
//            withdrawAccountUsecase.execute(new BankUiCommandData("113", new Company("Duy", "vduy@gmail.com", null, 9), AccountType.CHECKING, 100.0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Test Deposit credit card
        DepositCreditAccountUsecase usecase = new DepositCreditAccountUsecase(CreditCardService.getInstance());
        try {
            System.out.println("Credit Balance Before deposit: " + CreditCardService.getInstance().loadAccount("111").getBalance());
            usecase.execute(new DepositCreditAccountCommandData(
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
            chargeUsecase.execute(new ChargeCreditAccountCommandData(
                    "111", 100, "deposit"
            ));
            System.out.println("Credit Balance After charge: " + CreditCardService.getInstance().loadAccount("111").getBalance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
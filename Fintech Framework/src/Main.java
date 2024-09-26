import domain.creditcard.service.CreditCardServiceImpl;
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
        // Test create credit card
        CreateCreditAccountUsecase createCreditAccountUsecase = new CreateCreditAccountUsecase(CreditCardServiceImpl.getInstance());
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

            System.out.println(CreditCardServiceImpl.getInstance().loadAccount("112").getAccountType());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test Deposit credit card
        DepositCreditAccountUsecase usecase = new DepositCreditAccountUsecase(CreditCardServiceImpl.getInstance());
        try {
            System.out.println("Credit Balance Before deposit: " + CreditCardServiceImpl.getInstance().loadAccount("111").getBalance());
            usecase.execute(new DepositUiDTO(
                    "111", 100, "deposit"
            ));
            System.out.println("Credit Balance After deposit: " + CreditCardServiceImpl.getInstance().loadAccount("111").getBalance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test Withdraw credit card
        ChargeCreditAccountUsecase chargeUsecase = new ChargeCreditAccountUsecase(CreditCardServiceImpl.getInstance());
        try {
            System.out.println("Credit Balance Before charge: " + CreditCardServiceImpl.getInstance().loadAccount("111").getBalance());
            chargeUsecase.execute(new ChargeCreditUiDTO(
                    "111", 100, "deposit"
            ));
            System.out.println("Credit Balance After charge: " + CreditCardServiceImpl.getInstance().loadAccount("111").getBalance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
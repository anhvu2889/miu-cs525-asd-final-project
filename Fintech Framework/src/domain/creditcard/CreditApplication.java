package domain.creditcard;

import domain.creditcard.service.CreditCardService;
import domain.creditcard.service.CreditCardServiceImpl;
import domain.creditcard.ui.CreditCardFrameConfig;
import domain.creditcard.ui.CreditCardMainFrameBuilder;
import domain.creditcard.ui.frame.CreditCardMainFrame;
import domain.creditcard.usecase.ChargeCreditAccountUsecase;
import domain.creditcard.usecase.CreateCreditAccountUsecase;
import domain.creditcard.usecase.DepositCreditAccountUsecase;
import domain.creditcard.usecase.LoadCreditCardUiContentUsecase;

public class CreditApplication {
    public static void main(String[] args) {
        CreditCardService creditCardService = CreditCardServiceImpl.getInstance();
        CreditCardMainFrame creditCardMainFrame = CreditCardMainFrameBuilder.getInstance()
                .withAccountService(creditCardService)
                .withTitle("Credit Card Application")
                .withMainFrameConfig(new CreditCardFrameConfig())
                .withAddAccountCommand(new CreateCreditAccountUsecase(creditCardService))
                .withFrameUpdateCommand(new LoadCreditCardUiContentUsecase(creditCardService))
                .withChargeCommand(new ChargeCreditAccountUsecase(creditCardService))
                .withDepositCommand(new DepositCreditAccountUsecase(creditCardService))
//                .withBillCreationCommand(new BillCreationUICommand(CreditCardService.getInstance()))
                .build();
        creditCardMainFrame.setVisible(true);
    }
}

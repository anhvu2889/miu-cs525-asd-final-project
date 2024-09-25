package domain.creditcard;

import domain.creditcard.ui.CreditCardFrameConfig;
import domain.creditcard.ui.CreditCardMainFrameBuilder;
import domain.creditcard.ui.frame.CreditCardMainFrame;
import domain.creditcard.usecase.ChargeCreditAccountUsecase;
import domain.creditcard.usecase.CreateCreditAccountUsecase;
import domain.creditcard.usecase.DepositCreditAccountUsecase;
import domain.creditcard.usecase.LoadCreditCardUiContentUsecase;

public class CreditApplication {
    public static void main(String[] args) {
        CreditCardMainFrame creditCardMainFrame = CreditCardMainFrameBuilder.getInstance()
                .withAccountService(CreditCardService.getInstance())
                .withTitle("Credit Card Application")
                .withMainFrameConfig(new CreditCardFrameConfig())
                .withAddAccountCommand(new CreateCreditAccountUsecase(CreditCardService.getInstance()))
                .withFrameUpdateCommand(new LoadCreditCardUiContentUsecase(CreditCardService.getInstance()))
                .withChargeCommand(new ChargeCreditAccountUsecase(CreditCardService.getInstance()))
                .withDepositCommand(new DepositCreditAccountUsecase(CreditCardService.getInstance()))
//                .withBillCreationCommand(new BillCreationUICommand(CreditCardService.getInstance()))
                .build();
        creditCardMainFrame.setVisible(true);
    }
}

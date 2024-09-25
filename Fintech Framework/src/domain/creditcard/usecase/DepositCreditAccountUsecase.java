package domain.creditcard.usecase;

import domain.creditcard.CreditCardService;
import domain.creditcard.dto.DepositCreditAccountCommandData;
import domain.framework.ui.command.UICommand;

public class DepositCreditAccountUsecase implements UICommand<DepositCreditAccountCommandData> {
    private final CreditCardService creditCardService;

    public DepositCreditAccountUsecase(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @Override
    public void execute(DepositCreditAccountCommandData uiCommandData) throws RuntimeException {
        try {
            creditCardService.deposit(uiCommandData.accountNumber(), uiCommandData.amount(), uiCommandData.description());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

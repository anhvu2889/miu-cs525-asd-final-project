package domain.creditcard.usecase;

import domain.creditcard.CreditCardService;
import domain.creditcard.dto.ChargeCreditAccountCommandData;
import domain.framework.ui.command.UICommand;

public class ChargeCreditAccountUsecase implements UICommand<ChargeCreditAccountCommandData> {
    private final CreditCardService creditCardService;

    public ChargeCreditAccountUsecase(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @Override
    public void execute(ChargeCreditAccountCommandData uiCommandData) throws RuntimeException {
        try {
            creditCardService.charge(uiCommandData.accountNumber(), uiCommandData.amount(), uiCommandData.description());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

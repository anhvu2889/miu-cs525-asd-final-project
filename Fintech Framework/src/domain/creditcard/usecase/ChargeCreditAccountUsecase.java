package domain.creditcard.usecase;

import domain.creditcard.service.CreditCardService;
import domain.creditcard.dto.ChargeCreditUiDTO;
import domain.framework.ui.command.UICommand;

public class ChargeCreditAccountUsecase implements UICommand<ChargeCreditUiDTO> {
    private final CreditCardService creditCardService;

    public ChargeCreditAccountUsecase(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @Override
    public void execute(ChargeCreditUiDTO uiCommandData) throws RuntimeException {
        try {
            creditCardService.charge(uiCommandData.getAccountNumber(), uiCommandData.getAmount(), uiCommandData.getDescription());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

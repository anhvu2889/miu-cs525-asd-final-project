package domain.creditcard.usecase;

import domain.creditcard.service.CreditCardService;
import domain.framework.ui.command.UICommand;
import domain.framework.ui.dto.DepositUiDTO;

public class DepositCreditAccountUsecase implements UICommand<DepositUiDTO> {
    private final CreditCardService creditCardService;

    public DepositCreditAccountUsecase(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @Override
    public void execute(DepositUiDTO uiCommandData) throws RuntimeException {
        try {
            creditCardService.deposit(uiCommandData.getAccountNumber(), uiCommandData.getAmount(), uiCommandData.getDescription());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

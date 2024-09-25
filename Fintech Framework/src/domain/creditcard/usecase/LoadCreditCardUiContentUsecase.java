package domain.creditcard.usecase;

import domain.creditcard.CreditCardService;
import domain.creditcard.dto.LoadContentCreditUiDTO;
import domain.framework.ui.command.UICommand;

public class LoadCreditCardUiContentUsecase implements UICommand<LoadContentCreditUiDTO> {
    private final CreditCardService creditCardService;

    public LoadCreditCardUiContentUsecase(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @Override
    public void execute(LoadContentCreditUiDTO uiCommandData) throws RuntimeException {
        try {
            uiCommandData.setAccounts(creditCardService.getAccounts());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

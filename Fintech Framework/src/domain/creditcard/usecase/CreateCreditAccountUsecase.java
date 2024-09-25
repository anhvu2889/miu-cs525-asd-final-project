package domain.creditcard.usecase;

import domain.creditcard.CreditCardService;
import domain.creditcard.dto.NewCreditUiDTO;
import domain.creditcard.usecase.interest.abstractfactory.CreditCardFactory;
import domain.framework.ui.command.UICommand;

public class CreateCreditAccountUsecase implements UICommand<NewCreditUiDTO> {
    private final CreditCardService creditCardService;

    public CreateCreditAccountUsecase(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @Override
    public void execute(NewCreditUiDTO newCreditUiDTO) throws RuntimeException {
        try {
            CreditCardFactory factory = new CreditCardFactory(newCreditUiDTO);
            creditCardService.createCreditAccount(factory);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

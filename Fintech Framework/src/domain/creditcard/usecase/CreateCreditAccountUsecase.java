package domain.creditcard.usecase;

import domain.creditcard.CreditCardService;
import domain.creditcard.dto.NewCreditAccountCommandData;
import domain.creditcard.usecase.interest.abstractfactory.CreditCardFactory;
import domain.framework.ui.command.UICommand;

public class CreateCreditAccountUsecase implements UICommand<NewCreditAccountCommandData> {
    private final CreditCardService creditCardService;

    public CreateCreditAccountUsecase(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @Override
    public void execute(NewCreditAccountCommandData newCreditAccountCommandData) throws RuntimeException {
        try {
            CreditCardFactory factory = new CreditCardFactory(newCreditAccountCommandData);
            creditCardService.createCreditAccount(factory);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

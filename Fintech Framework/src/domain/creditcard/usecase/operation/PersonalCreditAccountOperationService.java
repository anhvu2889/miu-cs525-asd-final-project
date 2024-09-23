package domain.creditcard.usecase.operation;

import domain.framework.entity.Account;
import domain.framework.usecase.operation.PersonalAccountOperationService;

public class PersonalCreditAccountOperationService extends PersonalAccountOperationService {

    public PersonalCreditAccountOperationService(Account account) {
        super(account);
    }

    @Override
    public double getMaximumAmount() {
        return 400;
    }
}

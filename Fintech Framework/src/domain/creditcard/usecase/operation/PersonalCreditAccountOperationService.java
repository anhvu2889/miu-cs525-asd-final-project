package domain.creditcard.usecase.operation;

import domain.framework.entity.Account;
import domain.framework.usecase.operation.PersonalAccountOperationService;
import driver.repository.AccountRepository;

public class PersonalCreditAccountOperationService extends PersonalAccountOperationService {

    public PersonalCreditAccountOperationService(Account account, AccountRepository accountRepository) {
        super(account, accountRepository);
    }

    @Override
    public double getMaximumAmount() {
        return 400;
    }
}

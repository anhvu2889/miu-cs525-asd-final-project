package domain.banking.usecase.management.operation;

import domain.framework.entity.Account;
import domain.framework.usecase.operation.PersonalAccountOperationService;

public class PersonalBankingAccountOperationService extends PersonalAccountOperationService {

    public PersonalBankingAccountOperationService(Account account) {
        super(account);
    }

    @Override
    public double getMaximumAmount() {
        return 500;
    }
}

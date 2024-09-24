package domain.banking.usecase.management.operation;

import domain.framework.entity.Account;
import domain.framework.usecase.operation.PersonalAccountOperationService;
import driver.repository.AccountRepository;

public class PersonalBankingAccountOperationService extends PersonalAccountOperationService {

    public PersonalBankingAccountOperationService(Account account, AccountRepository aRepository) {
        super(account, aRepository);
    }

    @Override
    public double getMaximumAmount() {
        return 500;
    }
}

package domain.framework.usecase.operation;

import domain.framework.entity.Account;
import driver.repository.AccountRepository;

public class CompanyAccountOperationService extends AccountOperationServiceImpl {
    public CompanyAccountOperationService(Account account, AccountRepository accountRepository) {
        super(account, accountRepository);
    }

    @Override
    protected void postProcessing(double amount) {
        //TODO: Send notification
        System.out.println(this.getClass().getSimpleName() + " postProcessing " + amount);
    }
}

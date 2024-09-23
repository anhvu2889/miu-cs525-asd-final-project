package domain.framework.usecase.operation;

import domain.framework.entity.Account;

public class CompanyAccountOperationService extends AccountOperationServiceImpl {
    public CompanyAccountOperationService(Account account) {
        super(account);
    }

    @Override
    protected void postProcessing(double amount) {
        //TODO: Send notification
        System.out.println(this.getClass().getSimpleName() + " postProcessing " + amount);
    }
}

package domain.framework.usecase.operation;

import domain.framework.entity.Account;
import driver.repository.AccountRepository;

public abstract class PersonalAccountOperationService extends AccountOperationServiceImpl {

    private static final int MIN_AMOUNT = 0;

    public PersonalAccountOperationService(Account account, AccountRepository accountRepository) {
        super(account, accountRepository);

    }

    @Override
    protected void postProcessing(double amount) {

        Account account = getAccount();
        double balance = account.getBalance();
        if (balance >= getMaximumAmount() || balance <= MIN_AMOUNT) {
            //TODO: Send the notification
            System.out.println(this.getClass().getSimpleName() + " postProcessing " + amount);
        }
    }

    public  abstract double getMaximumAmount();
}

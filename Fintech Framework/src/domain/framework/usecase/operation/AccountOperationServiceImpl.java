package domain.framework.usecase.operation;

import domain.framework.entity.Account;

public abstract class AccountOperationServiceImpl implements AccountOperationService{

    private Account account;

    public AccountOperationServiceImpl(Account account) {
        this.account = account;
    }

    @Override
    public void deposit(double amount) {
        account.deposit(amount);
        postProcessing(amount);
    }

    @Override
    public void withdraw(double amount) {
        account.withdraw(amount);
        postProcessing(amount);
    }

    @Override
    public void addInterest(double amount) {
        account.addInterest(amount);
    }

    public Account getAccount() {
        return account;
    }

    protected abstract void postProcessing(double amount);
}

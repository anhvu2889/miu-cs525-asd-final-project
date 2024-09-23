package domain.framework.usecase.operation;

import domain.framework.entity.Account;
import domain.framework.usecase.operation.interest.InterestCalculator;

public abstract class AccountOperationServiceImpl implements AccountOperationService{

    private final Account account;
    private InterestCalculator interestCalculator;

    public AccountOperationServiceImpl(Account account) {
        this.account = account;
    }

    public void setInterestCalculator(InterestCalculator interestCalculator) {
        this.interestCalculator = interestCalculator;
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
    public void addInterest() {

//        double amount = interestCalculator.calculateInterest(account.getBalance());
//        account.addInterest(amount);
//        loadAllAccount().forEach();
        account.calculateInterest(account.getBalance());
    }

    public Account getAccount() {
        return account;
    }

    protected abstract void postProcessing(double amount);
}

package domain.framework.usecase;

import domain.framework.entity.Account;

public interface AccountOperationUseCase {
    void deposit(Account account, double amount);
    void withdraw(Account account, double amount);
    void addInterest(Account account, double amount);
}

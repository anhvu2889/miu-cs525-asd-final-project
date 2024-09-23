package domain.framework.usecase.operation.transaction;

import domain.framework.entity.Account;

public class WithdrawCommand implements Command {
    private final Account account;
    private final double amount;

    public WithdrawCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
//        account.withdraw(amount);
    }
}

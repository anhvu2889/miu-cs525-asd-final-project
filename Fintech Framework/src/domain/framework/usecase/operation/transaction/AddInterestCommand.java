package domain.framework.usecase.operation.transaction;

import domain.framework.entity.Account;

public class AddInterestCommand implements Command {
    private final Account account;
    private final double amount;

    public AddInterestCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
//        account.addInterest(amount);
    }
}

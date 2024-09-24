package domain.framework.entity;

import domain.framework.utils.BankHelper;

public class CreditAccount extends Account {
    public CreditAccount(String number, Customer customer) {
        super(number, customer);
    }

    @Override
    public double getBalance() {
        double balance = 0;
        for (AccountEntry entry : getEntries()) {
            if (BankHelper.isInLastMonth(entry.getDate())) {
                balance += entry.getAmount();
            }
        }
        return balance;
    }

    @Override
    protected void handleInterest(double interest) {

    }
}

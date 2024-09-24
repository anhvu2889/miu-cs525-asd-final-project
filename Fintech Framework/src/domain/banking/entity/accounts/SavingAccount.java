package domain.banking.entity.accounts;

import domain.banking.interest.SavingInterestCalculatorStrategy;
import domain.framework.entity.Account;
import domain.framework.entity.Customer;

public class SavingAccount extends Account {
    public SavingAccount(String number, Customer customer) {
        super(number, customer);
        super.setInterestCalculator(new SavingInterestCalculatorStrategy());
    }
}

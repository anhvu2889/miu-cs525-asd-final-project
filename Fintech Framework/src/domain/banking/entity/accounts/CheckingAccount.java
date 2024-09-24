package domain.banking.entity.accounts;

import domain.banking.interest.CheckingInterestCalculatorStrategy;
import domain.framework.entity.Account;
import domain.framework.entity.Customer;

public class CheckingAccount extends Account {
    public CheckingAccount(String number, Customer customer) {
        super(number, customer);
        super.setInterestCalculator(new CheckingInterestCalculatorStrategy());
    }
}

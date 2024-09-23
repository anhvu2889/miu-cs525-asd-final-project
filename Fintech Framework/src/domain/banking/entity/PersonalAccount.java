package domain.banking.entity;

import domain.framework.entity.Account;
import domain.framework.entity.Customer;

public class PersonalAccount extends Account {

    public PersonalAccount(String number, Customer customer) {
        super(number, customer);
    }
}

package domain.banking.entity.customers;

import domain.framework.entity.Address;
import domain.framework.entity.Customer;

import java.time.LocalDate;

public class Person extends Customer {

    private final LocalDate dateOfBirth;

    public Person(String name, String email, Address address, LocalDate dateOfBirth) {
        super(name, address, email);
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    @Override
    public String getCustomerType() {
        return "Person";
    }

}
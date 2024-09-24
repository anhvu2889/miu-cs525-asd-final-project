package domain.banking.entity.customers;

import domain.framework.entity.Address;
import domain.framework.entity.Customer;

public class Company extends Customer {
    private final long numberOfEmployees;

    public Company(String name, String email, Address address, long numOfEmployees) {
        super(name, address, email);
        this.numberOfEmployees = numOfEmployees;
    }

    public long getNumberOfEmployees() {
        return this.numberOfEmployees;
    }

    @Override
    public String getCustomerType() {
        return "Company";
    }

}
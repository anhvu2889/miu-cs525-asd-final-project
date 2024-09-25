package domain.framework.entity;

import java.time.LocalDate;

public class Customer {
    private final String name;
    private final Address address;
    private final LocalDate creationDate;
    private final String email;

    public Customer(String name, Address address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.creationDate = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getCustomerType() {
        return "Customer";
    }

    public String getEmail() {
        return email;
    }
}

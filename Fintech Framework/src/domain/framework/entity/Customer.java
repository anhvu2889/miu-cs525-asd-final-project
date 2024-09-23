package domain.framework.entity;

import java.time.LocalDate;

public class Customer {
    private final String name;
    private final Address address;
    private final LocalDate dateOfBirth;
    private final LocalDate creationDate;
    private final String email;
    public Customer(String name, Address address, LocalDate dateOfBirth, LocalDate creationDate, String email) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.creationDate = creationDate;
        this.email = email;
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
}

package domain.framework.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Customer {
    private final String name;
    private final Address address;
    private final LocalDate dateOfBirth;
    private final LocalDate creationDate;
    private final String email;

    @JsonCreator
    public Customer(@JsonProperty("name") String name,
                    @JsonProperty("address") Address address,
                    @JsonProperty("dateOfBirth") LocalDate dateOfBirth,
                    @JsonProperty("creationDate") LocalDate creationDate,
                    @JsonProperty("email") String email) {
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

    public LocalDate getDateOfBirth() {return dateOfBirth;}

    public String getEmail() {return email;}
}

package domain.framework.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
    private final String name;
    private final Address address;
    private final LocalDate creationDate;
    private final String email;

    @JsonCreator
    public Customer(@JsonProperty("name") String name,
                    @JsonProperty("address") Address address,
                    @JsonProperty("email") String email) {
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

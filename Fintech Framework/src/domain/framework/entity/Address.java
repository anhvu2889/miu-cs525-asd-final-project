package domain.framework.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    private final String street;
    private final String city;
    private final String state;
    private final String zip;

    @JsonCreator
    public Address(@JsonProperty("street") String street,
                   @JsonProperty("city") String city,
                   @JsonProperty("state") String state,
                   @JsonProperty("zip") String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

}

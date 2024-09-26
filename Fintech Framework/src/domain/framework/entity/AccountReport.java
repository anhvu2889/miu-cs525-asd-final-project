package domain.framework.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountReport {
    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private String accountNumber;

    public AccountReport(Account account) {
        this.customerName = account.getCustomer().getName();
        this.customerEmail = account.getCustomer().getEmail();

        Address address = account.getCustomer().getAddress();
        this.customerAddress = String.format("%s %s %s %s", address.getStreet(), address.getCity(), address.getZip(), address.getState());
        this.accountNumber = account.getNumber();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}

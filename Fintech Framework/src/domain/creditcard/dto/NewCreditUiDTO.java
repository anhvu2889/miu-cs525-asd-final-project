package domain.creditcard.dto;

import domain.creditcard.entity.CreditCardType;
import domain.framework.entity.Customer;

import java.time.LocalDate;

public class NewCreditUiDTO {
    String accountNumber;
    Customer customer;
    CreditCardType creditCardType;
    LocalDate expiredDate;

    public NewCreditUiDTO(String accountNumber, Customer customer, CreditCardType creditCardType, LocalDate expiredDate) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.creditCardType = creditCardType;
        this.expiredDate = expiredDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }
}

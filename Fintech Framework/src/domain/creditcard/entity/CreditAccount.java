package domain.creditcard.entity;

import domain.framework.entity.Account;
import domain.framework.entity.Customer;
import domain.framework.strategy.interest.MinimumPaymentCalculatorStrategy;

import java.time.LocalDate;

public class CreditAccount extends Account {

    private LocalDate exprDate;
    private CreditCardType accountType;
    private MinimumPaymentCalculatorStrategy minimumPaymentStrategy;

    public CreditAccount(String accNumber, Customer customer, LocalDate expirationDate, CreditCardType accountType) {
        super(accNumber, customer);
        this.exprDate = expirationDate;
        this.accountType = accountType;
    }

    public void setMinimumPaymentStrategy(MinimumPaymentCalculatorStrategy strategy) {
        this.minimumPaymentStrategy = strategy;
    }

    public MinimumPaymentCalculatorStrategy getMinimumPaymentStrategy() {
        return this.minimumPaymentStrategy;
    }

    public LocalDate getExprDate() {
        return this.exprDate;
    }

    public CreditCardType getAccountType() {
        return accountType;
    }
}
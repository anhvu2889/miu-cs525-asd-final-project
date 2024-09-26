package domain.creditcard.strategy.interest.monthlyinterest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import domain.framework.strategy.interest.InterestCalculatorStrategy;

public class GoldMonthlyInterestCalculatorStrategy implements InterestCalculatorStrategy {
    private final double monthlyInterest;

    @JsonCreator
    public GoldMonthlyInterestCalculatorStrategy(@JsonProperty("monthlyInterest") double monthlyInterest) {
        this.monthlyInterest = monthlyInterest;
    }
    @Override
    public double calculateInterest(double balance) {
        return balance * monthlyInterest;
    }

    public double getMonthlyInterest() {
        return monthlyInterest;
    }
}

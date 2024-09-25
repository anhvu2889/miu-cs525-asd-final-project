package domain.creditcard.usecase.interest.monthlyinterest;

import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;

public class GoldMonthlyInterestCalculatorStrategy implements InterestCalculatorStrategy {
    private final double monthlyInterest;

    public GoldMonthlyInterestCalculatorStrategy(double monthlyInterest) {
        this.monthlyInterest = monthlyInterest;
    }
    @Override
    public double calculateInterest(double balance) {
        return balance * monthlyInterest;
    }
}

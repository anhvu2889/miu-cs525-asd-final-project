package domain.creditcard.strategy.interest.monthlyinterest;

import domain.framework.strategy.interest.InterestCalculatorStrategy;

public class SilverMonthlyInterestCalculatorStrategy implements InterestCalculatorStrategy {
    private final double monthlyInterest;

    public SilverMonthlyInterestCalculatorStrategy(double monthlyInterest) {
        this.monthlyInterest = monthlyInterest;
    }

    @Override
    public double calculateInterest(double balance) {
        return balance * monthlyInterest;
    }
}

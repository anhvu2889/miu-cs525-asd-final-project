package domain.creditcard.usecase.interest.monthlyinterest;

import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;

public class SilverMonthlyInterestCalculatorStrategy implements InterestCalculatorStrategy {
    private double monthlyInterest = 0.08;

    @Override
    public double calculateInterest(double balance) {
        return balance * monthlyInterest;
    }
}

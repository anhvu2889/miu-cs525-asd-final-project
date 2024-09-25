package domain.creditcard.usecase.interest.monthlyinterest;

import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;

public class BronzeMonthlyInterestCalculator implements InterestCalculatorStrategy {
    private double monthlyInterest = 0.1;

    @Override
    public double calculateInterest(double balance) {
        return balance * monthlyInterest;
    }
}

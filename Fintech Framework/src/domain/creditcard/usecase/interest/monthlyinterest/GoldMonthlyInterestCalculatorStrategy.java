package domain.creditcard.usecase.interest.monthlyinterest;

import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;

public class GoldMonthlyInterestCalculatorStrategy implements InterestCalculatorStrategy {
    private double monthlyInterest = 0.06;

    @Override
    public double calculateInterest(double balance) {
        return balance * monthlyInterest;
    }
}

package domain.creditcard.usecase.interest.calculator;

import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;

public class GoldInterestCalculatorStrategy implements InterestCalculatorStrategy {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.06;
    }
}

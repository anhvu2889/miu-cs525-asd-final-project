package domain.creditcard.usecase.interest.calculator;

import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;

public class SilverInterestCalculatorStrategy implements InterestCalculatorStrategy {
    @Override
    public double getMonthlyInterest(double balance) {
        return 0;
    }
}

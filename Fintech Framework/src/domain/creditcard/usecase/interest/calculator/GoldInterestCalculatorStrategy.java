package domain.creditcard.usecase.interest.calculator;

import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;

public class GoldInterestCalculatorStrategy implements InterestCalculatorStrategy {
    @Override
    public double getMonthlyInterest(double balance) {
        return 0;
    }
}

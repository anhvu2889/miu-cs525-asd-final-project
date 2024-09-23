package domain.creditcard.usecase.interest.calculator;

import domain.framework.usecase.operation.interest.InterestCalculator;

public class SilverInterestCalculator implements InterestCalculator {
    @Override
    public double getMonthlyInterest(double balance) {
        return 0;
    }
}

package domain.creditcard.usecase.interest.calculator;

import domain.framework.usecase.operation.interest.InterestCalculator;

public class BronzeInterestCalculator implements InterestCalculator {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.1;
    }
}

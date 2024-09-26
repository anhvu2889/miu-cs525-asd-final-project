package domain.banking.interest;

import domain.framework.strategy.interest.InterestCalculatorStrategy;

public class CheckingInterestCalculatorStrategy implements InterestCalculatorStrategy {

    private final double percent = 0.01;

    @Override
    public double calculateInterest(double balance) {
        return balance * percent;
    }
}

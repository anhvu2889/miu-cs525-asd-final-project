package domain.banking.interest;

import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;

public class CheckingInterestCalculatorStrategy implements InterestCalculatorStrategy {

    private final double percent = 0.01;

    @Override
    public double getMonthlyInterest(double balance) {
        return balance * percent;
    }
}

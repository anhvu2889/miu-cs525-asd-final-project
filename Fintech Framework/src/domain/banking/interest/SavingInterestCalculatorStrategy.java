package domain.banking.interest;

import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;

public class SavingInterestCalculatorStrategy implements InterestCalculatorStrategy {

    private double interest = 0.1;

    @Override
    public double calculateInterest(double balance) {
        return balance * interest;
    }
}
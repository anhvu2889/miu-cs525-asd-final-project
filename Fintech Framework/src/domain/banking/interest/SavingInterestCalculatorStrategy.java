package domain.banking.interest;

import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;

public class SavingInterestCalculatorStrategy implements InterestCalculatorStrategy {

    private double interest = 0.1;

    @Override
    public double getMonthlyInterest(double balance) {
        return balance * interest;
    }
}

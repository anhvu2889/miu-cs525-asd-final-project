package domain.banking.usecase.interest.calculator;

import domain.framework.strategy.interest.InterestCalculatorStrategy;

public class PersonalBankingAccountInterestCalculator implements InterestCalculatorStrategy {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.05;
    }
}

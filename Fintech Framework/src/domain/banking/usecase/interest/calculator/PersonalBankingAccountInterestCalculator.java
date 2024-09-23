package domain.banking.usecase.interest.calculator;

import domain.framework.usecase.operation.interest.InterestCalculator;

public class PersonalBankingAccountInterestCalculator implements InterestCalculator {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.05;
    }
}

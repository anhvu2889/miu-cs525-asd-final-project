package domain.creditcard.usecase.interest;

import domain.creditcard.usecase.interest.calculator.GoldInterestCalculatorStrategy;
import domain.creditcard.usecase.interest.miniumpayment.GoldMinimumPaymentCalculator;
import domain.creditcard.usecase.interest.miniumpayment.MinimumPaymentCalculator;
import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;

public class GoldInterestRate implements InterestRate {
    @Override
    public InterestCalculatorStrategy interestCalculator() {
        return new GoldInterestCalculatorStrategy();
    }

    @Override
    public MinimumPaymentCalculator minimumPaymentCalculator() {
        return new GoldMinimumPaymentCalculator();
    }
}

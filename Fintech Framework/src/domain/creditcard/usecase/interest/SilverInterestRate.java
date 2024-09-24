package domain.creditcard.usecase.interest;

import domain.creditcard.usecase.interest.calculator.SilverInterestCalculatorStrategy;
import domain.creditcard.usecase.interest.miniumpayment.MinimumPaymentCalculator;
import domain.creditcard.usecase.interest.miniumpayment.SilverMinimumPaymentCalculator;
import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;

public class SilverInterestRate implements InterestRate{
    @Override
    public InterestCalculatorStrategy interestCalculator() {
        return new SilverInterestCalculatorStrategy();
    }

    @Override
    public MinimumPaymentCalculator minimumPaymentCalculator() {
        return new SilverMinimumPaymentCalculator();
    }
}

package domain.creditcard.usecase.interest;

import domain.creditcard.usecase.interest.calculator.SilverInterestCalculator;
import domain.creditcard.usecase.interest.miniumpayment.MinimumPaymentCalculator;
import domain.creditcard.usecase.interest.miniumpayment.SilverMinimumPaymentCalculator;
import domain.framework.usecase.operation.interest.InterestCalculator;

public class SilverInterestRate implements InterestRate{
    @Override
    public InterestCalculator interestCalculator() {
        return new SilverInterestCalculator();
    }

    @Override
    public MinimumPaymentCalculator minimumPaymentCalculator() {
        return new SilverMinimumPaymentCalculator();
    }
}

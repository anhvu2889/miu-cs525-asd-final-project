package domain.creditcard.usecase.interest;

import domain.creditcard.usecase.interest.calculator.GoldInterestCalculator;
import domain.creditcard.usecase.interest.miniumpayment.GoldMinimumPaymentCalculator;
import domain.creditcard.usecase.interest.miniumpayment.MinimumPaymentCalculator;
import domain.framework.usecase.operation.interest.InterestCalculator;

public class GoldInterestRate implements InterestRate {
    @Override
    public InterestCalculator interestCalculator() {
        return new GoldInterestCalculator();
    }

    @Override
    public MinimumPaymentCalculator minimumPaymentCalculator() {
        return new GoldMinimumPaymentCalculator();
    }
}

package domain.creditcard.usecase.interest;

import domain.creditcard.usecase.interest.miniumpayment.MinimumPaymentCalculator;
import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;

public class BronzeInterestRate implements InterestRate {
    @Override
    public InterestCalculatorStrategy interestCalculator() {
        return null;
    }

    @Override
    public MinimumPaymentCalculator minimumPaymentCalculator() {
        return null;
    }
}

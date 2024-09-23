package domain.creditcard.usecase.interest;

import domain.creditcard.usecase.interest.miniumpayment.MinimumPaymentCalculator;
import domain.framework.usecase.operation.interest.InterestCalculator;

public class BronzeInterestRate implements InterestRate {
    @Override
    public InterestCalculator interestCalculator() {
        return null;
    }

    @Override
    public MinimumPaymentCalculator minimumPaymentCalculator() {
        return null;
    }
}

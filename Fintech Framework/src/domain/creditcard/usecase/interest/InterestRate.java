package domain.creditcard.usecase.interest;

import domain.creditcard.usecase.interest.miniumpayment.MinimumPaymentCalculator;
import domain.framework.usecase.operation.interest.InterestCalculator;

public interface InterestRate {
    InterestCalculator interestCalculator();
    MinimumPaymentCalculator minimumPaymentCalculator();
}

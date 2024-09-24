package domain.creditcard.usecase.interest;

import domain.creditcard.usecase.interest.miniumpayment.MinimumPaymentCalculator;
import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;

public interface InterestRate {
    InterestCalculatorStrategy interestCalculator();
    MinimumPaymentCalculator minimumPaymentCalculator();
}

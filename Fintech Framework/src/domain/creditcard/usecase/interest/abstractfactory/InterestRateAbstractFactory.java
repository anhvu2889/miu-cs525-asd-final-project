package domain.creditcard.usecase.interest.abstractfactory;

import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;
import domain.framework.usecase.operation.interest.MinimumPaymentCalculatorStrategy;

public interface InterestRateAbstractFactory {
    InterestCalculatorStrategy interestCalculator();

    MinimumPaymentCalculatorStrategy minimumPaymentCalculator();
}

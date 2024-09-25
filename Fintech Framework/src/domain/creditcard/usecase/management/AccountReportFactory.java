package domain.creditcard.usecase.management;

import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;
import domain.framework.usecase.operation.interest.MinimumPaymentCalculatorStrategy;

public interface AccountReportFactory {
    InterestCalculatorStrategy getInterestCalculator();

    MinimumPaymentCalculatorStrategy getMinimumPaymentCalculator();
}

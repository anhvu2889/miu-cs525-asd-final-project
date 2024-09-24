package domain.creditcard.usecase.management;

import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;
import domain.framework.usecase.operation.interest.MinimumPaymentCalculator;

public interface AccountReportFactory {
    InterestCalculatorStrategy getInterestCalculator();

    MinimumPaymentCalculator getMinimumPaymentCalculator();
}

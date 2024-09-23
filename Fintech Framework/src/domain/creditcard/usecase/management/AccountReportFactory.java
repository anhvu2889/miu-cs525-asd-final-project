package domain.creditcard.usecase.management;

import domain.framework.usecase.operation.interest.InterestCalculator;
import domain.framework.usecase.operation.interest.MinimumPaymentCalculator;

public interface AccountReportFactory {
    InterestCalculator getInterestCalculator();
    MinimumPaymentCalculator getMinimumPaymentCalculator();
}

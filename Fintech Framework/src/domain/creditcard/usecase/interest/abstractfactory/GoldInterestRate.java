package domain.creditcard.usecase.interest.abstractfactory;

import domain.creditcard.usecase.interest.miniumpayment.GoldMinimumPaymentCalculatorStrategy;
import domain.creditcard.usecase.interest.monthlyinterest.GoldMonthlyInterestCalculatorStrategy;
import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;
import domain.framework.usecase.operation.interest.MinimumPaymentCalculatorStrategy;

public class GoldInterestRate implements InterestRateAbstractFactory {
    @Override
    public InterestCalculatorStrategy interestCalculator() {
        return new GoldMonthlyInterestCalculatorStrategy();
    }

    @Override
    public MinimumPaymentCalculatorStrategy minimumPaymentCalculator() {
        return new GoldMinimumPaymentCalculatorStrategy();
    }
}

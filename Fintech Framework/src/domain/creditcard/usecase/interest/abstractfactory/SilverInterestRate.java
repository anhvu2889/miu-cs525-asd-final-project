package domain.creditcard.usecase.interest.abstractfactory;

import domain.creditcard.usecase.interest.miniumpayment.SilverMinimumPaymentCalculatorStrategy;
import domain.creditcard.usecase.interest.monthlyinterest.SilverMonthlyInterestCalculatorStrategy;
import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;
import domain.framework.usecase.operation.interest.MinimumPaymentCalculatorStrategy;

public class SilverInterestRate implements InterestRateAbstractFactory {

    @Override
    public InterestCalculatorStrategy interestCalculator() {
        return new SilverMonthlyInterestCalculatorStrategy();
    }

    @Override
    public MinimumPaymentCalculatorStrategy minimumPaymentCalculator() {
        return new SilverMinimumPaymentCalculatorStrategy();
    }
}

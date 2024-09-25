package domain.creditcard.usecase.interest.abstractfactory;

import domain.creditcard.usecase.interest.miniumpayment.BronzeMinimumPaymentCalculatorStrategy;
import domain.creditcard.usecase.interest.monthlyinterest.BronzeMonthlyInterestCalculator;
import domain.framework.usecase.operation.interest.InterestCalculatorStrategy;
import domain.framework.usecase.operation.interest.MinimumPaymentCalculatorStrategy;

public class BronzeInterestRate implements InterestRateAbstractFactory {
    @Override
    public InterestCalculatorStrategy interestCalculator() {
        return new BronzeMonthlyInterestCalculator();
    }

    @Override
    public MinimumPaymentCalculatorStrategy minimumPaymentCalculator() {
        return new BronzeMinimumPaymentCalculatorStrategy();
    }
}

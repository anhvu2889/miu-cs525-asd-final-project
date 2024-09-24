package domain.creditcard.usecase.interest.miniumpayment;

import domain.framework.usecase.operation.interest.MinimumPaymentCalculatorStrategy;

public class SilverMinimumPaymentCalculatorStrategy implements MinimumPaymentCalculatorStrategy {
    private double minimumPaymentRate = 0.12;

    @Override
    public double calculateMinimumPayment(double balance) {
        return minimumPaymentRate * balance;
    }
}

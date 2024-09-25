package domain.creditcard.usecase.interest.miniumpayment;

import domain.framework.usecase.operation.interest.MinimumPaymentCalculatorStrategy;

public class GoldMinimumPaymentCalculatorStrategy implements MinimumPaymentCalculatorStrategy {
    private double minimumPaymentRate = 0.1;

    @Override
    public double calculateMinimumPayment(double balance) {
        return minimumPaymentRate * balance;
    }
}

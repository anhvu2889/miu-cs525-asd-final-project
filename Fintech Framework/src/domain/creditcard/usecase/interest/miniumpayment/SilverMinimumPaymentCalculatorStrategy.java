package domain.creditcard.usecase.interest.miniumpayment;

import domain.framework.usecase.operation.interest.MinimumPaymentCalculatorStrategy;

public class SilverMinimumPaymentCalculatorStrategy implements MinimumPaymentCalculatorStrategy {
    private final double minimumPaymentRate;

    public SilverMinimumPaymentCalculatorStrategy(double minimumPaymentRate) {
        this.minimumPaymentRate = minimumPaymentRate;
    }

    @Override
    public double calculateMinimumPayment(double balance) {
        return minimumPaymentRate * balance;
    }
}

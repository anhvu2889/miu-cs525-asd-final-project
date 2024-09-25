package domain.creditcard.usecase.interest.miniumpayment;

import domain.framework.usecase.operation.interest.MinimumPaymentCalculatorStrategy;

public class GoldMinimumPaymentCalculatorStrategy implements MinimumPaymentCalculatorStrategy {
    private final double minimumPaymentRate;

    public GoldMinimumPaymentCalculatorStrategy(double minimumPaymentRate) {
        this.minimumPaymentRate = minimumPaymentRate;
    }

    @Override
    public double calculateMinimumPayment(double balance) {
        return minimumPaymentRate * balance;
    }
}

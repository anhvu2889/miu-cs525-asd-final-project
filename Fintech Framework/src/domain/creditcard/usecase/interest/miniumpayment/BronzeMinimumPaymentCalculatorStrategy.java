package domain.creditcard.usecase.interest.miniumpayment;

import domain.framework.usecase.operation.interest.MinimumPaymentCalculatorStrategy;

public class BronzeMinimumPaymentCalculatorStrategy implements MinimumPaymentCalculatorStrategy {
    private final double minimumPaymentRate;

    public BronzeMinimumPaymentCalculatorStrategy(double minimumPaymentRate) {
        this.minimumPaymentRate = minimumPaymentRate;
    }

    @Override
    public double calculateMinimumPayment(double balance) {
        return balance * minimumPaymentRate;
    }
}

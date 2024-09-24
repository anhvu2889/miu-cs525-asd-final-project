package domain.creditcard.usecase.interest.miniumpayment;

import domain.framework.usecase.operation.interest.MinimumPaymentCalculatorStrategy;

public class BronzeMinimumPaymentCalculatorStrategy implements MinimumPaymentCalculatorStrategy {
    private double minimumPaymentRate = 0.14;

    @Override
    public double calculateMinimumPayment(double balance) {
        return balance * minimumPaymentRate;
    }
}

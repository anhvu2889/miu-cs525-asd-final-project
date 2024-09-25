package domain.creditcard.usecase.interest.miniumpayment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import domain.framework.usecase.operation.interest.MinimumPaymentCalculatorStrategy;

public class SilverMinimumPaymentCalculatorStrategy implements MinimumPaymentCalculatorStrategy {
    private final double minimumPaymentRate;

    @JsonCreator
    public SilverMinimumPaymentCalculatorStrategy(@JsonProperty("minimumPaymentRate") double minimumPaymentRate) {
        this.minimumPaymentRate = minimumPaymentRate;
    }

    @Override
    public double calculateMinimumPayment(double balance) {
        return minimumPaymentRate * balance;
    }

    public double getMinimumPaymentRate() {
        return minimumPaymentRate;
    }
}

package domain.creditcard.strategy.interest.miniumpayment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import domain.framework.strategy.interest.MinimumPaymentCalculatorStrategy;

public class BronzeMinimumPaymentCalculatorStrategy implements MinimumPaymentCalculatorStrategy {
    private final double minimumPaymentRate;

    @JsonCreator
    public BronzeMinimumPaymentCalculatorStrategy(@JsonProperty("minimumPaymentRate") double minimumPaymentRate) {
        this.minimumPaymentRate = minimumPaymentRate;
    }

    @Override
    public double calculateMinimumPayment(double balance) {
        return balance * minimumPaymentRate;
    }

    public double getMinimumPaymentRate() {
        return minimumPaymentRate;
    }
}

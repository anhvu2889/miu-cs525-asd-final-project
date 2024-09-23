package domain.creditcard.usecase.interest.miniumpayment;

public class SilverMinimumPaymentCalculator implements MinimumPaymentCalculator {
    @Override
    public double calculateMinimumPayment(double balance) {
        return 0;
    }
}

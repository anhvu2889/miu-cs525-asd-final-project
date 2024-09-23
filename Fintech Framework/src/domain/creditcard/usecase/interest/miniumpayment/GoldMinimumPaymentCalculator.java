package domain.creditcard.usecase.interest.miniumpayment;

public class GoldMinimumPaymentCalculator implements MinimumPaymentCalculator {
    @Override
    public double calculateMinimumPayment(double balance) {
        return 0;
    }
}

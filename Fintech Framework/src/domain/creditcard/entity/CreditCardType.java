package domain.creditcard.entity;

public enum CreditCardType {
    GOLD(0.06, 0.1),
    SILVER(0.08, 0.12),
    BRONZE(0.1, 0.14);

    private double monthlyInterestRate;
    private double minimumPaymentRate;

    CreditCardType(double monthlyInterestRate, double minimumPaymentRate) {
        this.monthlyInterestRate = monthlyInterestRate;
        this.minimumPaymentRate = minimumPaymentRate;
    }

    public double getMonthlyInterestRate() {
        return monthlyInterestRate;
    }

    public double getMinimumPaymentRate() {
        return minimumPaymentRate;
    }

    public void setMonthlyInterestRate(double monthlyInterestRate) {
        this.monthlyInterestRate = monthlyInterestRate;
    }

    public void setMinimumPaymentRate(double minimumPaymentRate) {
        this.minimumPaymentRate = minimumPaymentRate;
    }
}

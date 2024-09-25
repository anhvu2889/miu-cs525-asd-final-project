package domain.creditcard.entity;

public enum CreditCardType {
    GOLD("Gold", 0.06, 0.1),
    SILVER("Silver", 0.08, 0.12),
    BRONZE("Bronze", 0.1, 0.14);

    private String name;
    private double monthlyInterestRate;
    private double minimumPaymentRate;

    CreditCardType(String name, double monthlyInterestRate, double minimumPaymentRate) {
        this.name = name;
        this.monthlyInterestRate = monthlyInterestRate;
        this.minimumPaymentRate = minimumPaymentRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

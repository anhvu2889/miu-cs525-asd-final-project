package domain.creditcard.usecase.management;

public class MonthyReport {
    private double previousBalance;
    private double totalCharges;
    private double totalCredits;
    private double newBalance;
    private double totalDue;

    public MonthyReport(double previousBalance, double totalCharges, double totalCredits, double newBalance, double totalDue) {
        this.previousBalance = previousBalance;
        this.totalCharges = totalCharges;
        this.totalCredits = totalCredits;
        this.newBalance = newBalance;
        this.totalDue = totalDue;
    }

    public void setPreviousBalance(double previousBalance) {
        this.previousBalance = previousBalance;
    }

    public void setTotalCharges(double totalCharges) {
        this.totalCharges = totalCharges;
    }

    public void setTotalCredits(double totalCredits) {
        this.totalCredits = totalCredits;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }

    public void setTotalDue(double totalDue) {
        this.totalDue = totalDue;
    }
}

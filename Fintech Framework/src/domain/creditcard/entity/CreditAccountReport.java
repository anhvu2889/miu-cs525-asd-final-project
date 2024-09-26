package domain.creditcard.entity;

import domain.framework.entity.Account;
import domain.framework.entity.AccountReport;

public class CreditAccountReport extends AccountReport {

    private double previousBalance;
    private double totalCharges;
    private double totalCredits;
    private double newBalance;
    private double totalDue;

    public CreditAccountReport(Account account, double previousBalance, double totalCharges, double totalCredits, double newBalance, double totalDue) {
        super(account);
        this.previousBalance = previousBalance;
        this.totalCharges = totalCharges;
        this.totalCredits = totalCredits;
        this.newBalance = newBalance;
        this.totalDue = totalDue;
    }

    public double getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(double totalCharges) {
        this.totalCharges = totalCharges;
    }

    public double getPreviousBalance() {
        return previousBalance;
    }

    public void setPreviousBalance(double previousBalance) {
        this.previousBalance = previousBalance;
    }

    public double getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(double totalCredits) {
        this.totalCredits = totalCredits;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }

    public double getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(double totalDue) {
        this.totalDue = totalDue;
    }

    @Override
    public String toString() {
        return "Customer Name= " + getCustomerName() +
                "\nCustomer Email= " + getCustomerEmail() +
                "\nCustomer Address= " + getCustomerAddress() +
                "\nAccount Number= " + getAccountNumber() +
                "\nPrevious Balance=" + previousBalance +
                "\nTotal Charges=" + totalCharges +
                "\nTotal Credits=" + totalCredits +
                "\nNew Balance=" + newBalance +
                "\nTotal Due=" + totalDue;
    }
}

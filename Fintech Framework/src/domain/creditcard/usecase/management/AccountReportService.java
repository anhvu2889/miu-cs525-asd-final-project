package domain.creditcard.usecase.management;

import domain.framework.entity.Account;
import domain.framework.entity.AccountEntry;
import domain.framework.usecase.operation.interest.InterestCalculator;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Locale;

public  class AccountReportService {
    private Account account;
    private AccountReportFactory accountReportFactory;
    public AccountReportService(Account account) {
        this.account = account;
    }

    public MonthyReport generateReport() {
        double monthlyInterest = accountReportFactory.getInterestCalculator().calculateInterest(account.getBalance());
        double totalDue = accountReportFactory.getMinimumPaymentCalculator().calculateMinimumPayment();
        MonthyReport monthyReport = new MonthyReport(getPreviousBalance(), getTotalCharge(), getTotalCredits(), monthlyInterest, totalDue);
        return monthyReport;
    }

    private double getPreviousBalance() {

        //TODO: calculate
        List<AccountEntry> entries = account.getEntries();
        LocalDate today = LocalDate.now();
        LocalDate previousMonth =  LocalDate.now().minusMonths(1);
        return 0;
    }

    private double getTotalCharge() {
        //TODO
        return 0;
    }

    private double getTotalCredits() {
        //TODO
        return 0;
    }

}

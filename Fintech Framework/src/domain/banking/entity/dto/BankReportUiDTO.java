package domain.banking.entity.dto;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class BankReportUiDTO {
    private String accountNUmber;
    private LocalDate startDate;
    private LocalDate endDate;
    private String allAccountsReport;

    public BankReportUiDTO(String accountNUmber, LocalDate startDate, LocalDate endDate) {
        this.accountNUmber = accountNUmber;

        if (startDate == null || endDate == null) {
            LocalDate today = LocalDate.now();
            this.startDate = today.with(TemporalAdjusters.firstDayOfMonth());
            this.endDate = today.with(TemporalAdjusters.lastDayOfMonth());
        } else {
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }

    public String getAllAccountsReport() {
        return allAccountsReport;
    }

    public void setAllAccountsReport(String allAccountsReport) {
        this.allAccountsReport = allAccountsReport;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getAccountNUmber() {
        return accountNUmber;
    }

    public void setAccountNUmber(String accountNUmber) {
        this.accountNUmber = accountNUmber;
    }
}

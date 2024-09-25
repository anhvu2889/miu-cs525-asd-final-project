package domain.banking.entity.dto;

import java.time.LocalDate;

public class BankReportUiDTO {
    private String accountNUmber;
    private LocalDate startDate;
    private LocalDate endDate;
    private String allAccountsReport;

    public BankReportUiDTO(String accountNUmber) {
        this.accountNUmber = accountNUmber;
        this.startDate = LocalDate.EPOCH;
        this.endDate = LocalDate.now();
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

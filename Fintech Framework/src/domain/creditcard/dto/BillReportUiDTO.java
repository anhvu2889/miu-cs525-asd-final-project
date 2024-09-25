package domain.creditcard.dto;

import java.time.LocalDate;

public class BillReportUiDTO {
    private String accountNUmber;
    private LocalDate startDate;
    private LocalDate endDate;
    private String monthlyBillReport;

    public BillReportUiDTO(String accountNUmber) {
        this.accountNUmber = accountNUmber;
        this.startDate = LocalDate.EPOCH;
        this.endDate = LocalDate.now();
    }

    public String getMonthlyBillReport() {
        return monthlyBillReport;
    }

    public void setMonthlyBillReport(String monthlyBillReport) {
        this.monthlyBillReport = monthlyBillReport;
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

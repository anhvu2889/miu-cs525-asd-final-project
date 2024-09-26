package domain.creditcard.dto;

public class BillReportUiDTO {
    private String accountNUmber;
    private String monthlyBillReport;

    public BillReportUiDTO(String accountNUmber) {
        this.accountNUmber = accountNUmber;
    }

    public String getMonthlyBillReport() {
        return monthlyBillReport;
    }

    public void setMonthlyBillReport(String monthlyBillReport) {
        this.monthlyBillReport = monthlyBillReport;
    }

    public String getAccountNUmber() {
        return accountNUmber;
    }

    public void setAccountNUmber(String accountNUmber) {
        this.accountNUmber = accountNUmber;
    }
}

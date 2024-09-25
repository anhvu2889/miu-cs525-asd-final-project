package domain.banking.usecase.report;

import domain.banking.BankService;
import domain.banking.entity.BankingAccountReport;

import java.time.LocalDate;
import java.util.List;

public class AccountHistoryReportUsecase {

    private final BankService bankService;

    public AccountHistoryReportUsecase(BankService bankService) {
        this.bankService = bankService;
    }

    public List<BankingAccountReport> execute(String accountNumber, LocalDate startDate, LocalDate endDate) throws RuntimeException {
        try {
            return bankService.reportAccountHistory(accountNumber, startDate, endDate);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
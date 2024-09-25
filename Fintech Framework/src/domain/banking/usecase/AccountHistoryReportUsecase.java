package domain.banking.usecase;

import domain.banking.BankService;
import domain.banking.entity.dto.BankReportUiDTO;
import domain.framework.ui.command.UICommand;

public class AccountHistoryReportUsecase implements UICommand<BankReportUiDTO> {

    private final BankService bankService;

    public AccountHistoryReportUsecase(BankService bankService) {
        this.bankService = bankService;
    }

    public void execute(BankReportUiDTO bankReportUiDTO) throws RuntimeException {
        try {
            bankService.reportAccountHistory(bankReportUiDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
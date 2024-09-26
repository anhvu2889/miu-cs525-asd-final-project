package domain.banking.usecase;

import domain.banking.entity.dto.BankReportUiDTO;
import domain.banking.service.BankAccountService;
import domain.framework.ui.command.UICommand;

public class AccountHistoryReportUsecase implements UICommand<BankReportUiDTO> {

    private final BankAccountService bankAccountService;

    public AccountHistoryReportUsecase(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    public void execute(BankReportUiDTO bankReportUiDTO) throws RuntimeException {
        try {
            bankAccountService.reportAccountHistory(bankReportUiDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
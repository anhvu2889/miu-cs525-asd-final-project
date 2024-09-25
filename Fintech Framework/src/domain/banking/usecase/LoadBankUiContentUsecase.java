package domain.banking.usecase;

import domain.banking.service.BankAccountService;
import domain.framework.ui.command.UICommand;
import domain.framework.ui.dto.LoadAccountsContentUIDTO;

public class LoadBankUiContentUsecase implements UICommand<LoadAccountsContentUIDTO> {
    private final BankAccountService bankAccountService;

    public LoadBankUiContentUsecase(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @Override
    public void execute(LoadAccountsContentUIDTO uiCommandData) throws RuntimeException {
        try {
            uiCommandData.setAccounts(bankAccountService.getAccounts());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

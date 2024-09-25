package domain.banking.usecase;

import domain.banking.BankService;
import domain.framework.ui.command.UICommand;
import domain.framework.ui.dto.LoadAccountsContentUIDTO;

public class LoadBankUiContentUsecase implements UICommand<LoadAccountsContentUIDTO> {
    private final BankService bankService;

    public LoadBankUiContentUsecase(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public void execute(LoadAccountsContentUIDTO uiCommandData) throws RuntimeException {
        try {
            uiCommandData.setAccounts(bankService.getAccounts());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package domain.banking.usecase;

import domain.banking.BankService;
import domain.banking.entity.BankUiCommandData;
import domain.framework.ui.command.UICommand;

public class AddInterestUsecase implements UICommand<BankUiCommandData> {
    private final BankService bankService;

    public AddInterestUsecase(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public void execute(BankUiCommandData uiCommandData) {
        bankService.addInterest();
    }
}

package domain.banking.usecase;

import domain.banking.service.BankAccountService;
import domain.banking.entity.dto.AddInterestUiDTO;
import domain.framework.ui.command.UICommand;

public class AddInterestUsecase implements UICommand<AddInterestUiDTO> {
    private final BankAccountService bankAccountService;

    public AddInterestUsecase(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @Override
    public void execute(AddInterestUiDTO uiCommandData) {
        bankAccountService.addInterest();
    }
}

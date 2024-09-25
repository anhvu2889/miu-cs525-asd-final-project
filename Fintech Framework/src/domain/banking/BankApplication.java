package domain.banking;

import domain.banking.service.BankAccountService;
import domain.banking.service.BankAccountServiceImpl;
import domain.banking.ui.BankFrameConfig;
import domain.banking.ui.BankMainFrameBuilder;
import domain.banking.ui.frame.BankMainFrame;
import domain.banking.usecase.*;

public class BankApplication {
    public static void main(String[] args) {
        BankAccountService bankAccountService = BankAccountServiceImpl.getInstance();
        BankMainFrame bankMainFrame = BankMainFrameBuilder.getInstance()
                .withTitle("Bank Application.")
                .withAccountService(bankAccountService)
                .withMainFrameConfig(new BankFrameConfig())
                .withAddPersonalAccountCommand(new CreatePersonalAccountUsecase(bankAccountService))
                .withAddCompanyAccountCommand(new CreatecompanyAccountUsecase(bankAccountService))
                .withAddInterestCommand(new AddInterestUsecase(bankAccountService))
                .withWithdrawCommand(new WithdrawAccountUsecase(bankAccountService))
                .withFrameUpdateCommand(new LoadBankUiContentUsecase(bankAccountService))
                .withDepositCommand(new DepositAccountUsecase(bankAccountService))
                .withAllAccReportCommand(new AccountHistoryReportUsecase(bankAccountService))
                .build();
        bankMainFrame.setVisible(true);
    }
}
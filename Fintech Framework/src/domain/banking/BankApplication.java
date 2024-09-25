package domain.banking;

import domain.banking.ui.BankFrameConfig;
import domain.banking.ui.BankMainFrameBuilder;
import domain.banking.ui.frame.BankMainFrame;
import domain.banking.usecase.*;

public class BankApplication {
    public static void main(String[] args) {
        BankMainFrame bankMainFrame = BankMainFrameBuilder.getInstance()
                .withTitle("Bank Application.")
                .withAccountService(BankService.getInstance())
                .withMainFrameConfig(new BankFrameConfig())
                .withAddPersonalAccountCommand(new CreatePersonalAccountUsecase(BankService.getInstance()))
                .withAddCompanyAccountCommand(new CreateCompanyAccountUsecase(BankService.getInstance()))
                .withAddInterestCommand(new AddInterestUsecase(BankService.getInstance()))
                .withWithdrawCommand(new WithdrawAccountUsecase(BankService.getInstance()))
                .withFrameUpdateCommand(new LoadBankUiContentUsecase(BankService.getInstance()))
                .withDepositCommand(new DepositAccountUsecase(BankService.getInstance()))
//                .withAllAccReportCommand(new AccountHistoryReportUsecase(BankService.getInstance()))
                .build();
        bankMainFrame.setVisible(true);
    }
}
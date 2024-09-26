package domain.banking.ui;

import domain.banking.service.BankAccountService;
import domain.banking.service.BankAccountServiceImpl;
import domain.banking.entity.dto.AddInterestUiDTO;
import domain.banking.entity.dto.BankReportUiDTO;
import domain.banking.entity.dto.CreateCompanyAccountUIDTO;
import domain.banking.entity.dto.CreatePersonalAccountUiDTO;
import domain.banking.ui.frame.BankMainFrame;
import domain.banking.usecase.*;
import domain.framework.ui.command.UICommand;
import domain.framework.ui.dto.DepositUiDTO;
import domain.framework.ui.dto.LoadAccountsContentUIDTO;
import domain.framework.ui.dto.WithdrawUiDTO;
import domain.framework.ui.frame.FrameTemplate;

@SuppressWarnings("ALL")
public class BankMainFrameBuilder {
    private static final BankMainFrameBuilder INSTANCE = new BankMainFrameBuilder();

    private BankAccountService accountService = BankAccountServiceImpl.getInstance();
    private BankFrameConfig mainFrameConfig = new BankFrameConfig();
    private UICommand<CreatePersonalAccountUiDTO> addPersonalAccountUICommand = new CreatePersonalAccountUsecase(accountService);
    private UICommand<CreateCompanyAccountUIDTO> addCompanyAccountUICommand = new CreatecompanyAccountUsecase(accountService);
    private UICommand<LoadAccountsContentUIDTO> frameUpdateUICommand = new LoadBankUiContentUsecase(accountService);
    private UICommand<DepositUiDTO> depositUICommand = new DepositAccountUsecase(accountService);
    private UICommand<WithdrawUiDTO> withdrawUICommand = new WithdrawAccountUsecase(accountService);
    private UICommand<AddInterestUiDTO> addInterestUICommand = new AddInterestUsecase(accountService);
    private UICommand<BankReportUiDTO> generateAllAccReportsUICommand = new AccountHistoryReportUsecase(accountService);
    private static String frameTitle = FrameTemplate.NO_TITLE;

    private BankMainFrameBuilder() {
    }

    public static BankMainFrameBuilder getInstance() {
        return INSTANCE;
    }

    public BankMainFrameBuilder withAccountService(BankAccountService service) {
        accountService = service;
        return INSTANCE;
    }

    public BankMainFrameBuilder withFrameUpdateCommand(UICommand<LoadAccountsContentUIDTO> frameUpdateCommand) {
        frameUpdateUICommand = frameUpdateCommand;
        return INSTANCE;
    }

    public BankMainFrameBuilder withDepositCommand(UICommand<DepositUiDTO> depositCommand) {
        depositUICommand = depositCommand;
        return INSTANCE;
    }

    public BankMainFrameBuilder withAddPersonalAccountCommand(UICommand<CreatePersonalAccountUiDTO> addAccountCommand) {
        addPersonalAccountUICommand = addAccountCommand;
        return INSTANCE;
    }

    public BankMainFrameBuilder withAddCompanyAccountCommand(UICommand<CreateCompanyAccountUIDTO> addAccountCommand) {
        addCompanyAccountUICommand = addAccountCommand;
        return INSTANCE;
    }

    public BankMainFrameBuilder withWithdrawCommand(UICommand<WithdrawUiDTO> withdrawCommand) {
        withdrawUICommand = withdrawCommand;
        return INSTANCE;
    }

    public BankMainFrameBuilder withAddInterestCommand(UICommand<AddInterestUiDTO> addInterestCommand) {
        addInterestUICommand = addInterestCommand;
        return INSTANCE;
    }

    public BankMainFrameBuilder withAllAccReportCommand(UICommand<BankReportUiDTO> allAccReportCommand) {
        generateAllAccReportsUICommand = allAccReportCommand;
        return INSTANCE;
    }

    public BankMainFrameBuilder withMainFrameConfig(BankFrameConfig bankMainFrameConfig) {
        mainFrameConfig = bankMainFrameConfig;
        return INSTANCE;
    }

    public BankMainFrameBuilder withTitle(String title) {
        frameTitle = title;
        return INSTANCE;
    }

    public BankMainFrame build() {
        BankMainFrame bankMainFrame = new BankMainFrame(mainFrameConfig, frameTitle);
        bankMainFrame.setAddPersonalAccountCommand(addPersonalAccountUICommand);
        bankMainFrame.setAddCompanyAccountCommand(addCompanyAccountUICommand);
        bankMainFrame.setFrameUpdateCommand(frameUpdateUICommand);
        bankMainFrame.setDepositCommand(depositUICommand);
        bankMainFrame.setWithdrawCommand(withdrawUICommand);
        bankMainFrame.setAddInterestCommand(addInterestUICommand);
        bankMainFrame.setAllAccReportCommand(generateAllAccReportsUICommand);

        return bankMainFrame;
    }
}

package domain.creditcard.ui;

import domain.creditcard.CreditCardService;
import domain.creditcard.dto.BillReportUiDTO;
import domain.creditcard.dto.ChargeCreditUiDTO;
import domain.creditcard.dto.LoadContentCreditUiDTO;
import domain.creditcard.dto.NewCreditUiDTO;
import domain.creditcard.ui.frame.CreditCardMainFrame;
import domain.creditcard.usecase.ChargeCreditAccountUsecase;
import domain.creditcard.usecase.CreateCreditAccountUsecase;
import domain.creditcard.usecase.DepositCreditAccountUsecase;
import domain.creditcard.usecase.LoadCreditCardUiContentUsecase;
import domain.framework.ui.command.UICommand;
import domain.framework.ui.dto.DepositUiDTO;

import static domain.framework.ui.frame.FrameTemplate.NO_TITLE;

public class CreditCardMainFrameBuilder {
    private static final CreditCardMainFrameBuilder INSTANCE = new CreditCardMainFrameBuilder();

    private CreditCardService creditCardService = CreditCardService.getInstance();
    private CreditCardFrameConfig mainFrameConfig = new CreditCardFrameConfig();
    private UICommand<NewCreditUiDTO> addAccountUICommand = new CreateCreditAccountUsecase(creditCardService);
    private UICommand<LoadContentCreditUiDTO> frameUpdateUICommand = new LoadCreditCardUiContentUsecase(creditCardService);
    private UICommand<DepositUiDTO> depositUICommand = new DepositCreditAccountUsecase(creditCardService);
    private UICommand<ChargeCreditUiDTO> chargeUICommand = new ChargeCreditAccountUsecase(creditCardService);
    //    private UICommand<BillReportUiDTO> billCreationUICommand = new CreditAccountReportUseCase(creditCardService);
    private static String frameTitle = NO_TITLE;

    private CreditCardMainFrameBuilder() {
    }

    public static CreditCardMainFrameBuilder getInstance() {
        return INSTANCE;
    }

    public CreditCardMainFrameBuilder withAccountService(CreditCardService service) {
        creditCardService = service;
        return INSTANCE;
    }

    public CreditCardMainFrameBuilder withFrameUpdateCommand(UICommand<LoadContentCreditUiDTO> frameUpdateCommand) {
        frameUpdateUICommand = frameUpdateCommand;
        return INSTANCE;
    }

    public CreditCardMainFrameBuilder withDepositCommand(UICommand<DepositUiDTO> depositCommand) {
        depositUICommand = depositCommand;
        return INSTANCE;
    }

    public CreditCardMainFrameBuilder withAddAccountCommand(UICommand<NewCreditUiDTO> addAccountCommand) {
        addAccountUICommand = addAccountCommand;
        return INSTANCE;
    }

    public CreditCardMainFrameBuilder withChargeCommand(UICommand<ChargeCreditUiDTO> chargeCommand) {
        chargeUICommand = chargeCommand;
        return INSTANCE;
    }

    public CreditCardMainFrameBuilder withBillCreationCommand(UICommand<BillReportUiDTO> billCreationCommand) {
//        billCreationUICommand = billCreationCommand;
        return INSTANCE;
    }

    public CreditCardMainFrameBuilder withMainFrameConfig(CreditCardFrameConfig creditCardUIConfig) {
        mainFrameConfig = creditCardUIConfig;
        return INSTANCE;
    }

    public CreditCardMainFrameBuilder withTitle(String title) {
        frameTitle = title;
        return INSTANCE;
    }

    public CreditCardMainFrame build() {
        CreditCardMainFrame creditCardMainFrame = new CreditCardMainFrame(mainFrameConfig, frameTitle);
        creditCardMainFrame.setAddCreditCardAccountCommand(addAccountUICommand);
        creditCardMainFrame.setFrameUpdateCommand(frameUpdateUICommand);
        creditCardMainFrame.setDepositCommand(depositUICommand);
        creditCardMainFrame.setChargeCreditCardCommand(chargeUICommand);
//        creditCardMainFrame.setBillReportCommand(billCreationUICommand);
        return creditCardMainFrame;
    }
}

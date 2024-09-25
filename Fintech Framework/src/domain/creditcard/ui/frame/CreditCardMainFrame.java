package domain.creditcard.ui.frame;

import domain.creditcard.dto.BillReportUiDTO;
import domain.creditcard.dto.ChargeCreditUiDTO;
import domain.creditcard.dto.LoadContentCreditUiDTO;
import domain.creditcard.dto.NewCreditUiDTO;
import domain.creditcard.ui.CreditCardUICommandController;
import domain.creditcard.ui.dialog.AddCreditCardAccountDialog;
import domain.creditcard.ui.dialog.BillReportDialog;
import domain.framework.ui.command.UICommand;
import domain.framework.ui.dialog.DepositDialog;
import domain.framework.ui.dialog.WithdrawDialog;
import domain.framework.ui.frame.FrameConfig;
import domain.framework.ui.frame.FrameTemplate;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CreditCardMainFrame extends FrameTemplate implements CreditCardUICommandController {

    private UICommand<NewCreditUiDTO> addCreditCardAccountCommand;
    private UICommand<BillReportUiDTO> billReportCommand;
    private UICommand<ChargeCreditUiDTO> chargeCreditCardCommand;

    public CreditCardMainFrame(FrameConfig frameConfig, String title) {
        super(frameConfig);
        constructFrame(title);
    }

    private final ActionListener createCreditCardAccount = (actionEvent) -> {
        openDialog(new AddCreditCardAccountDialog(this, addCreditCardAccountCommand));
    };

    private final ActionListener deposit = (actionEvent) -> {
        int selection = getSelectionIndex();
        if (selection >= 0) {
            String creditCardNumber = (String) getModel().getValueAt(selection, frameConfig.getAccountNumberColumnIndex());
            String customerName = (String) getModel().getValueAt(selection, frameConfig.getCustomerNameColumnIndex());
            openDialog(new DepositDialog(this, creditCardNumber, customerName, getDepositCommand()), 430, 15, 275, 200);
        }
    };

    private final ActionListener charge = (actionEvent) -> {
        int selection = getSelectionIndex();
        if (selection >= 0) {
            String creditCardNumber = (String) getModel().getValueAt(selection, frameConfig.getAccountNumberColumnIndex());
            openDialog(new WithdrawDialog(this, creditCardNumber, chargeCreditCardCommand), 430, 15, 275, 140);
        }
    };

    private final ActionListener generateBill = (ActionListener) -> {
        int selection = getSelectionIndex();
        if (selection >= 0) {
            String creditCardNumber = (String) getModel().getValueAt(selection, frameConfig.getAccountNumberColumnIndex());
            openDialog(new BillReportDialog(this, this.billReportCommand, creditCardNumber), 450, 20, 400, 350);
        }
    };

    @Override
    public Map<String, ButtonConfig> buttonConfigs() {
        Map<String, ButtonConfig> buttons = new HashMap<>();
        buttons.put("Add credit account", new ButtonConfig(createCreditCardAccount, 24, 20, 192, 33));
        buttons.put("Deposit", new ButtonConfig(deposit, 468, 104, 96, 33));
        buttons.put("Charge", new ButtonConfig(charge, 468, 144, 96, 33));
        buttons.put("Generate Bill", new ButtonConfig(generateBill, 240, 20, 192, 33));
        buttons.put("Exit", new ButtonConfig(getExitEventHandler(), 468, 248, 96, 31));
        return buttons;
    }

    @Override
    protected void loadContent() {
        LoadContentCreditUiDTO loadContentCreditUIDTO = new LoadContentCreditUiDTO();
        getFrameUpdateCommand().execute(loadContentCreditUIDTO);
        loadContentCreditUIDTO.getAccounts().forEach(this::tableRow);
    }

    @Override
    public void setAddCreditCardAccountCommand(UICommand addCreditCardAccountCommand) {
        this.addCreditCardAccountCommand = addCreditCardAccountCommand;
    }

    @Override
    public void setBillReportCommand(UICommand billReportCommand) {
        this.billReportCommand = billReportCommand;
    }

    @Override
    public void setChargeCreditCardCommand(UICommand chargeCreditCardCommand) {
        this.chargeCreditCardCommand = chargeCreditCardCommand;
    }
}

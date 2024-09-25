package domain.banking.ui.frame;

import domain.banking.entity.dto.AddInterestUiDTO;
import domain.banking.entity.dto.BankReportUiDTO;
import domain.banking.entity.dto.CreateCompanyAccountUIDTO;
import domain.banking.entity.dto.CreatePersonalAccountUiDTO;
import domain.banking.ui.BankUICommandController;
import domain.banking.ui.dialogs.AddCompanyAccountDialog;
import domain.banking.ui.dialogs.AddPersonalAccountDialog;
import domain.banking.ui.dialogs.ReportDialog;
import domain.framework.entity.Account;
import domain.framework.ui.command.UICommand;
import domain.framework.ui.dialog.DepositDialog;
import domain.framework.ui.dialog.WithdrawDialog;
import domain.framework.ui.dto.LoadAccountsContentUIDTO;
import domain.framework.ui.frame.FrameConfig;
import domain.framework.ui.frame.FrameTemplate;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class BankMainFrame extends FrameTemplate implements BankUICommandController {

    private UICommand<CreatePersonalAccountUiDTO> addPersonalAccountCommand;
    private UICommand<CreateCompanyAccountUIDTO> addCompanyAccountCommand;
    private UICommand<AddInterestUiDTO> addInterestUICommand;
    private UICommand<BankReportUiDTO> reportCreationUICommand;

    private final ActionListener personalAccount = (actionEvent) -> {
        openDialog(new AddPersonalAccountDialog(this, addPersonalAccountCommand));
    };

    private final ActionListener companyAccount = (actionEvent) -> {
        openDialog(new AddCompanyAccountDialog(this, addCompanyAccountCommand));
    };

    private final ActionListener allAccountsReport = (actionEvent) -> {
        int selection = getSelectionIndex();
        if (selection >= 0) {
            String accnr = (String) getModel().getValueAt(selection, frameConfig.getAccountNumberColumnIndex());
            openDialog(new ReportDialog(this, reportCreationUICommand, accnr));
        }
    };

    private final ActionListener deposit = (actionEvent) -> {
        int selection = getSelectionIndex();
        if (selection >= 0) {
            String accnr = (String) getModel().getValueAt(selection, frameConfig.getAccountNumberColumnIndex());
            String customerName = (String) getModel().getValueAt(selection, frameConfig.getCustomerNameColumnIndex());
            openDialog(new DepositDialog(this, accnr, customerName, getDepositCommand()), 430, 15, 275, 140);
        }
    };

    private final ActionListener addInterest = (actionEvent) -> {
        AddInterestUiDTO addInterestUIDTO = new AddInterestUiDTO();
        addInterestUICommand.execute(addInterestUIDTO);
        updateContent();

        JOptionPane.showMessageDialog(null, "Add interest to all accounts", "Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
    };

    private final ActionListener withdraw = (actionEvent) -> {
        int selection = getSelectionIndex();
        if (selection >= 0) {
            String accountNumber = (String) getModel().getValueAt(selection, frameConfig.getAccountNumberColumnIndex());
            openDialog(new WithdrawDialog(this, accountNumber, getWithdrawCommand()), 430, 15, 275, 140);
        }
    };


    BankMainFrame(FrameConfig<Account> frameConfig) {
        super(frameConfig);
        constructFrame(NO_TITLE);
    }

    public BankMainFrame(FrameConfig<Account> frameConfig, String title) {
        super(frameConfig);
        constructFrame(title);
    }


    @Override
    public Map<String, ButtonConfig> buttonConfigs() {
        Map<String, ButtonConfig> buttons = new HashMap<>();
        buttons.put("Add personal account", new ButtonConfig(personalAccount, 24, 20, 192, 33));
        buttons.put("Add company account", new ButtonConfig(companyAccount, 240, 20, 192, 33));
        buttons.put("Account Report", new ButtonConfig(allAccountsReport, 460, 20, 192, 33));
        buttons.put("Deposit", new ButtonConfig(deposit, 468, 104, 96, 33));
        buttons.put("Withdraw", new ButtonConfig(withdraw, 468, 150, 106, 33));
        buttons.put("Add Interest", new ButtonConfig(addInterest, 468, 190, 96, 33));
        buttons.put("Exit", new ButtonConfig(getExitEventHandler(), 468, 248, 96, 31));
        return buttons;
    }

    @Override
    protected void loadContent() {
        LoadAccountsContentUIDTO loadAccountsContentUIDTO = new LoadAccountsContentUIDTO();
        getFrameUpdateCommand().execute(loadAccountsContentUIDTO);
        loadAccountsContentUIDTO.getAccounts().forEach(this::tableRow);
    }

    @Override
    public void setAddPersonalAccountCommand(UICommand addAccountCommand) {
        this.addPersonalAccountCommand = addAccountCommand;
    }

    @Override
    public void setAddCompanyAccountCommand(UICommand addAccountCommand) {
        this.addCompanyAccountCommand = addAccountCommand;
    }

    @Override
    public void setAddInterestCommand(UICommand addInterestCommand) {
        this.addInterestUICommand = addInterestCommand;
    }

    @Override
    public void setAllAccReportCommand(UICommand allAccReportCommand) {
        this.reportCreationUICommand = allAccReportCommand;
    }
}

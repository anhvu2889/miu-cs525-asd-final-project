package domain.banking.ui.dialogs;
/*
		A basic implementation of the JDialog class.
*/

import domain.banking.entity.dto.BankReportUiDTO;
import domain.framework.ui.command.UICommand;
import domain.framework.ui.frame.FrameTemplate;

import javax.swing.*;

public class ReportDialog extends JDialog {
    private UICommand<BankReportUiDTO> reportUICommand;
    private String accountNumber;

    public ReportDialog(FrameTemplate parent, UICommand<BankReportUiDTO> uiCommand, String accountNumber) {
        super(parent);
        this.reportUICommand = uiCommand;
        this.accountNumber = accountNumber;
        initDialog();
    }

    private void initDialog() {
        getContentPane().setLayout(null);
        setSize(405, 367);
        setVisible(false);
        getContentPane().add(JScrollPane1);
        JScrollPane1.setBounds(24, 24, 358, 240);
        JScrollPane1.getViewport().add(JTextField1);
        JTextField1.setBounds(0, 0, 355, 237);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(156, 276, 96, 24);
        JButton_OK.addActionListener(e -> {
            dispose();
        });

        BankReportUiDTO bankReportUiDTO = new BankReportUiDTO(accountNumber);
        try {
            reportUICommand.execute(bankReportUiDTO);
            JTextField1.setText(bankReportUiDTO.getAllAccountsReport());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    JScrollPane JScrollPane1 = new JScrollPane();
    JTextArea JTextField1 = new JTextArea();
    JButton JButton_OK = new JButton();

}

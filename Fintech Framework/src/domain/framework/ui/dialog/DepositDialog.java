package domain.framework.ui.dialog;

import domain.framework.ui.command.UICommand;
import domain.framework.ui.dto.DepositUiDTO;
import domain.framework.ui.frame.FrameTemplate;

import javax.swing.*;
import java.awt.*;

public class DepositDialog extends JDialog {
    private UICommand<DepositUiDTO> depositUICommand;

    public DepositDialog(FrameTemplate parent, String accountNumber, String customerName, UICommand uiCommand) {
        super(parent);
        depositUICommand = uiCommand;
        initDialog(parent, accountNumber, customerName);
    }

    private void initDialog(FrameTemplate parent, String accountNumber, String customerName) {
        setTitle("Deposit");
        setModal(true);
        getContentPane().setLayout(null);
        setSize(268, 126);
        setVisible(false);
        JLabel1.setText("Acc Nr");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(Color.black);
        JLabel1.setBounds(12, 12, 48, 24);
        JLabel2.setText("Amount");
        getContentPane().add(JLabel2);
        JLabel2.setForeground(Color.black);
        JLabel2.setBounds(12, 48, 48, 24);
        JTextField_NAME.setEditable(false);
        getContentPane().add(JTextField_NAME);
        JTextField_NAME.setBounds(84, 12, 144, 24);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(36, 84, 84, 24);
        JButton_Cancel.setText("Cancel");
        JButton_Cancel.setActionCommand("Cancel");
        getContentPane().add(JButton_Cancel);
        JButton_Cancel.setBounds(156, 84, 84, 24);
        getContentPane().add(JTextField_Deposit);
        JTextField_Deposit.setBounds(84, 48, 144, 24);
        JTextField_NAME.setText(accountNumber);

        JButton_OK.addActionListener(e -> {
            DepositUiDTO depositUIDTO = new DepositUiDTO(accountNumber, Double.valueOf(JTextField_Deposit.getText()), "Deposit");
            try {
                depositUICommand.execute(depositUIDTO);
                parent.updateContent();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                dispose();
            }
        });
        JButton_Cancel.addActionListener(e -> dispose());
    }

    JLabel JLabel1 = new JLabel();
    JLabel JLabel2 = new JLabel();
    JTextField JTextField_NAME = new JTextField();
    JButton JButton_OK = new JButton();
    JButton JButton_Cancel = new JButton();
    JTextField JTextField_Deposit = new JTextField();

}
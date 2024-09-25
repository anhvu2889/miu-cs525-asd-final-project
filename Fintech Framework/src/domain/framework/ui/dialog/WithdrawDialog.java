package domain.framework.ui.dialog;

import domain.creditcard.dto.ChargeCreditUiDTO;
import domain.framework.ui.command.UICommand;
import domain.framework.ui.dto.WithdrawUiDTO;
import domain.framework.ui.frame.FrameTemplate;

import javax.swing.*;
import java.awt.*;


public class WithdrawDialog extends JDialog {
    private UICommand<WithdrawUiDTO> withdrawUICommand;

    public WithdrawDialog(FrameTemplate parent, String accountNumber, UICommand uiCommand) {
        super(parent);
        withdrawUICommand = uiCommand;
        initDialog(parent, accountNumber);
    }

    private void initDialog(FrameTemplate parent, String accountNumber) {
        setTitle("Withdraw");
        setModal(true);
        getContentPane().setLayout(null);
        setSize(277, 134);
        setVisible(false);
        JLabel1.setText("Acc Nr");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(Color.black);
        JLabel1.setBounds(12, 12, 48, 24);
        JLabel2.setText("Amount");
        getContentPane().add(JLabel2);
        JLabel2.setForeground(Color.black);
        JLabel2.setBounds(12, 36, 48, 24);
        JTextField_NAME.setEditable(false);
        getContentPane().add(JTextField_NAME);
        JTextField_NAME.setBounds(84, 12, 156, 20);
        getContentPane().add(JTextField_AMT);
        JTextField_AMT.setBounds(84, 36, 156, 20);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(48, 84, 84, 24);
        JButton_Calcel.setText("Cancel");
        JButton_Calcel.setActionCommand("Cancel");
        getContentPane().add(JButton_Calcel);
        JButton_Calcel.setBounds(156, 84, 84, 24);

        JTextField_NAME.setText(accountNumber);


        JButton_OK.addActionListener(e -> {
            ChargeCreditUiDTO chargeCreditUiDTO = new ChargeCreditUiDTO(accountNumber, Double.valueOf(JTextField_AMT.getText()), "Withdraw");
            try {
                withdrawUICommand.execute(chargeCreditUiDTO);
                parent.updateContent();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                dispose();
            }
        });
        JButton_Calcel.addActionListener(e -> dispose());
    }

    JLabel JLabel1 = new JLabel();
    JLabel JLabel2 = new JLabel();
    JTextField JTextField_NAME = new JTextField();
    JTextField JTextField_AMT = new JTextField();
    JButton JButton_OK = new JButton();
    JButton JButton_Calcel = new JButton();

}
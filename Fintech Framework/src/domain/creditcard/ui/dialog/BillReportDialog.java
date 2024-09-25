package domain.creditcard.ui.dialog;
/*
		A basic implementation of the JDialog class.
*/

import domain.creditcard.dto.BillReportUiDTO;
import domain.framework.ui.command.UICommand;
import domain.framework.ui.frame.FrameTemplate;

import javax.swing.*;

public class BillReportDialog extends JDialog {
    private UICommand<BillReportUiDTO> billCreationUICommand;

    public BillReportDialog(FrameTemplate parent, UICommand<BillReportUiDTO> uiCommand, String creditCardNumber) {
        super(parent);
        billCreationUICommand = uiCommand;
        initDialog(creditCardNumber);
    }

    private void initDialog(String creditCardNumber) {
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

        BillReportUiDTO billReportUiDTO = new BillReportUiDTO(creditCardNumber);
        try {
            billCreationUICommand.execute(billReportUiDTO);
            JTextField1.setText(billReportUiDTO.getMonthlyBillReport());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    JScrollPane JScrollPane1 = new JScrollPane();
    JTextArea JTextField1 = new JTextArea();
    JButton JButton_OK = new JButton();

}

package domain.framework.ui.frame;

import domain.framework.entity.Account;
import domain.framework.ui.UICommandController;
import domain.framework.ui.command.UICommand;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Map;

public abstract class FrameTemplate<T> extends JFrame implements UICommandController<T> {
    protected FrameConfig<Account> frameConfig;

    JPanel mainPanel = new JPanel();
    private DefaultTableModel model;
    protected JTable AccountTable;
    private JScrollPane AccountScrollPanel;

    public static final String NO_TITLE = "No Title.";

    private UICommand<T> frameUpdateCommand;
    private UICommand<T> depositCommand;
    private UICommand<T> withdrawCommand;

    public FrameTemplate(FrameConfig<Account> frameConfig) {
        this.frameConfig = frameConfig;
        addWindowListener(new SymWindow());
    }

    public abstract Map<String, ButtonConfig> buttonConfigs();

    public final void constructFrame(String title) {
        setupMainPanel(title, frameConfig);
        setupContentGrid(frameConfig);
        setupButtons(buttonConfigs());
    }

    private void setupButtons(Map<String, ButtonConfig> buttonConfigs) {
        for (Map.Entry<String, ButtonConfig> button : buttonConfigs.entrySet()) {
            JButton btn = new JButton();
            btn.setText(button.getKey());
            mainPanel.add(btn);
            btn.addActionListener(button.getValue().getActionListener());
            btn.setBounds(button.getValue().getX(), button.getValue().getY(), button.getValue().getWidth(), button.getValue().getHeight());
        }
    }

    private void setupContentGrid(FrameConfig<Account> frameConfig) {
        AccountScrollPanel = new JScrollPane();

        model = new DefaultTableModel();
        AccountTable = new JTable(model);
        for (String columnName : frameConfig.getColumnsOfAccountTable()) {
            model.addColumn(columnName);
        }
        AccountScrollPanel.setBounds(12, 92, frameConfig.getAccountScrollPanelWidth(), frameConfig.getAccountScrollPanelHeight());
        mainPanel.add(AccountScrollPanel);
        AccountScrollPanel.getViewport().add(AccountTable);
        AccountTable.setBounds(0, 0, frameConfig.getAccountTableWidth(), frameConfig.getAccountTableHeight());
    }

    private void setupMainPanel(String title, FrameConfig<Account> frameConfig) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        setSize(frameConfig.getFrameWidth(), frameConfig.getFrameHeight());
        setVisible(false);
        mainPanel.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, mainPanel);
        mainPanel.setBounds(0, 0, frameConfig.getFrameWidth(), frameConfig.getFrameHeight());
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void openDialog(JDialog jDialog) {
        openDialog(jDialog,450, 20, 300, 380);
    }

    public void openDialog(JDialog jDialog, int x, int y, int width, int height) {
        jDialog.setBounds(x, y, width, height);
        jDialog.show();
    }

    protected final ActionListener exit = (ActionListener) -> {
        System.exit(0);
    };

    public void updateContent() {
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }

        loadContent();
    }

    protected abstract void loadContent();

    protected void tableRow(Account account) {
        model.addRow(frameConfig.buildRow(account));
        AccountTable.getSelectionModel().setAnchorSelectionIndex(-1);
    }

    void exitApplication() {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
        }
    }

    public int getSelectionIndex() {
        return AccountTable.getSelectionModel().getMinSelectionIndex();
    }

    public ActionListener getExitEventHandler() {
        return exit;
    }

    public UICommand<T> getFrameUpdateCommand() {
        return frameUpdateCommand;
    }

    class SymWindow extends java.awt.event.WindowAdapter {
        public void windowClosing(WindowEvent event) {
            Object object = event.getSource();
            if (object instanceof FrameTemplate)
                MainFrm_windowClosing(event);
        }
    }

    void MainFrm_windowClosing(WindowEvent event) {
        MainFrm_windowClosing_Interaction1(event);
    }

    void MainFrm_windowClosing_Interaction1(WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }

    @Override
    public void setFrameUpdateCommand(UICommand<T> frameUpdateCommand) {
        this.frameUpdateCommand = frameUpdateCommand;
    }

    @Override
    public void setDepositCommand(UICommand<T> depositUICommand) {
        this.depositCommand = depositUICommand;
    }

    @Override
    public void setWithdrawCommand(UICommand<T> withdrawUICommand) {
        this.withdrawCommand = withdrawUICommand;
    }


    protected UICommand<T> getDepositCommand() {
        return depositCommand;
    }

    protected UICommand<T> getWithdrawCommand() {
        return withdrawCommand;
    }

    public static class ButtonConfig {
        private ActionListener actionListener;
        private int x;
        private int y;
        private int width;
        private int height;

        public ButtonConfig(ActionListener actionListener, int x, int y, int width, int height) {
            this.actionListener = actionListener;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public ActionListener getActionListener() {
            return actionListener;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }
}

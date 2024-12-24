package view.accounts;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AccountListWindow extends JFrame {

    private final String[] COLUMN_NAMES = {"ID", "Account Number", "Customer Name", "Account Type", "Currency", "Balance"};
    private JTable accountTable;
    private JScrollPane scrollPane;
    private JPanel buttonPanel;
    private JButton createButton;
    private JButton updateButton;
    private JButton suspendButton;

    public AccountListWindow() {
        initializeComponents();
    }

    private void initializeComponents() {
        this.setTitle("Account List");
        this.setLayout(new BorderLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        this.accountTable = new JTable();
        this.scrollPane = new JScrollPane(this.accountTable);
        this.scrollPane.setSize(600, 300);
        constraints.gridy = 0;
        constraints.gridx = 0;
        this.add(this.scrollPane, BorderLayout.CENTER);
        this.createButton = new JButton("Create Account");
        this.updateButton = new JButton("Update Account");
        this.suspendButton = new JButton("Suspend account");
        this.buttonPanel = new JPanel();
        this.buttonPanel.add(this.createButton, BorderLayout.WEST);
        this.buttonPanel.add(this.updateButton, BorderLayout.CENTER);
        this.buttonPanel.add(this.suspendButton, BorderLayout.EAST);
        constraints.gridy = 1;
        this.add(this.buttonPanel, BorderLayout.SOUTH);
        this.setSize(600, 400);
        this.setVisible(true);
    }

    public void setTableData(String[][] tableData) {
        DefaultTableModel tableModel = new DefaultTableModel(tableData, this.COLUMN_NAMES);
        this.accountTable.setModel(tableModel);
    }

    public String[] getCOLUMN_NAMES() {
        return COLUMN_NAMES;
    }

    public JTable getAccountTable() {
        return accountTable;
    }

    public void setAccountTable(JTable accountTable) {
        this.accountTable = accountTable;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public void setCreateButton(JButton createButton) {
        this.createButton = createButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }

    public JButton getSuspendButton() {
        return suspendButton;
    }

    public void setSuspendButton(JButton suspendButton) {
        this.suspendButton = suspendButton;
    }
}

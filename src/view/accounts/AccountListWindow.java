package view.accounts;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AccountListWindow extends JFrame {

    private final String[] COLUMN_NAMES = {"ID","Account Number", "Customer Name","Account Type", "Currency", "Balance"};
    private JTable accountTable;
    private JScrollPane scrollPane;
    private JPanel buttonPanel;
    private JButton updateButton;
    private JButton deleteButton;

    public AccountListWindow(){
        initializeComponents();
    }

    private void initializeComponents(){
        this.setTitle("Account List");
        this.accountTable = new JTable();
        this.scrollPane = new JScrollPane(this.accountTable);
        this.add(this.scrollPane);
        this.setSize(600, 400);
        this.setVisible(true);
    }

    public void setTableData(String[][] tableData){
        DefaultTableModel tableModel = new DefaultTableModel(tableData,this.COLUMN_NAMES);
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

    public JButton getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }
}

package controller;

import dao.abs.account.AccountDao;
import dao.abs.account.AccountDaoImpl;
import model.Account;
import service.AccountService;
import view.accounts.AccountListWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AccountListController {
    private final AccountService ACCOUNT_SERVICE;
    private final AccountListWindow ACCOUNT_LIST_WINDOW;

    public AccountListController(){
        this.ACCOUNT_SERVICE = new AccountService();
        this.ACCOUNT_LIST_WINDOW = new AccountListWindow();
        this.ACCOUNT_LIST_WINDOW.setTableData(prepareAccountData());
        this.ACCOUNT_LIST_WINDOW.getCreateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCreateButtonClick();
            }
        });

        this.ACCOUNT_LIST_WINDOW.getCreateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCreateButtonClick();
            }
        });

        this.ACCOUNT_LIST_WINDOW.getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleUpdateButtonClick();
            }
        });

        this.ACCOUNT_LIST_WINDOW.getSuspendButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSuspendButtonClick();
            }
        });
    }

    public String[][] prepareAccountData(){
        int columnCount = this.ACCOUNT_LIST_WINDOW.getCOLUMN_NAMES().length;
        List<Account> accountList = this.ACCOUNT_SERVICE.getAllAccounts();
        String[][] dataTable = new String[accountList.size()][columnCount];
        for(int i = 0; i <accountList.size(); i++ ) {
                dataTable[i] =  accountList.get(i).prepareDataForAccountList();
        }

        return dataTable;
    }


    public void handleCreateButtonClick(){
        new AccountCreateController();
    }
    public void handleUpdateButtonClick(){
        int row =this.ACCOUNT_LIST_WINDOW.getAccountTable().getSelectedRow();
        int id = Integer.parseInt(this.ACCOUNT_LIST_WINDOW.getAccountTable().getModel().getValueAt(row, 0).toString());
        new AccountUpdateController(this.ACCOUNT_SERVICE.getAccountById(id));
    }
    public void handleSuspendButtonClick(){
        int suspendChoice = JOptionPane.showConfirmDialog(this.ACCOUNT_LIST_WINDOW, "Do you want to suspend this account?");
        if(suspendChoice == JOptionPane.YES_OPTION){
            int row =this.ACCOUNT_LIST_WINDOW.getAccountTable().getSelectedRow();
            int id = Integer.parseInt(this.ACCOUNT_LIST_WINDOW.getAccountTable().getModel().getValueAt(row, 0).toString());
            this.ACCOUNT_SERVICE.suspendAccount(id);
        }
    }
}

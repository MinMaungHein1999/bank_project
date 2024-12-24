package controller;

import model.Account;
import model.AccountType;
import service.AccountService;
import view.accounts.AccountCreateWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountUpdateController {

    private final AccountCreateWindow ACCOUNT_CREATE_WINDOW;
    private final AccountService ACCOUNT_SERVICE;
    private Account account;
    public AccountUpdateController(Account account){
        this.account = account;
        this.ACCOUNT_SERVICE = new AccountService();
        this.ACCOUNT_CREATE_WINDOW = new AccountCreateWindow();
        this.ACCOUNT_CREATE_WINDOW.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSaveButtonAction();
            }
        });

        this.ACCOUNT_CREATE_WINDOW.getClearButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleClearButtonAction();
            }
        });
        populateAccountCreateWindow();
        disableInputFields();
    }

    public void populateAccountCreateWindow(){
        this.ACCOUNT_CREATE_WINDOW.getAccountNumberInput().setText(this.account.getAccountNumber());
        this.ACCOUNT_CREATE_WINDOW.getAmountInput().setText(String.valueOf(this.account.getBalance()));
        this.ACCOUNT_CREATE_WINDOW.getCustomerIdInput().setText(String.valueOf(this.account.getCustomer().getId()));
        this.ACCOUNT_CREATE_WINDOW.getAccountTypeCombo().setSelectedIndex(this.account.getAccountType());
        this.ACCOUNT_CREATE_WINDOW.getCurrencyCombo().setSelectedIndex(0);
    }

    private void disableInputFields(){
        this.ACCOUNT_CREATE_WINDOW.getAccountNumberInput().setEnabled(false);
        this.ACCOUNT_CREATE_WINDOW.getAmountInput().setEditable(false);
        this.ACCOUNT_CREATE_WINDOW.getCustomerIdInput().setEditable(false);
        this.ACCOUNT_CREATE_WINDOW.getAccountTypeCombo().setEditable(false);
        this.ACCOUNT_CREATE_WINDOW.getAccountTypeCombo().setEnabled(false);
        this.ACCOUNT_CREATE_WINDOW.getCurrencyCombo().setEditable(false);
        this.ACCOUNT_CREATE_WINDOW.getCurrencyCombo().setEnabled(false);
    }

    private void handleSaveButtonAction(){
        String newPassword = String.valueOf(this.ACCOUNT_CREATE_WINDOW.getPasswordInput().getPassword());
        String confirmPassword = String.valueOf(this.ACCOUNT_CREATE_WINDOW.getConfirmPasswordInput().getPassword());
        String accountNumber = this.ACCOUNT_CREATE_WINDOW.getAccountNumberInput().getText();
        this.ACCOUNT_SERVICE.updatePassword(newPassword, confirmPassword, accountNumber);
    }
    private void handleClearButtonAction(){
        this.ACCOUNT_CREATE_WINDOW.getPasswordInput().setText("");
        this.ACCOUNT_CREATE_WINDOW.getConfirmPasswordInput().setText("");
    }


}

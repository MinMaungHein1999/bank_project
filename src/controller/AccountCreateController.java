package controller;


import dto.AccountDto;
import exception.AccountCreateException;
import model.AccountType;
import service.AccountService;
import view.accounts.AccountCreateWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountCreateController {

    private final AccountService ACCOUNT_SERVICE = new AccountService();


    private AccountCreateWindow accountCreateWindow;

    public AccountCreateController() {
        this.accountCreateWindow = new AccountCreateWindow();
        this.accountCreateWindow.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSaveClick();
            }
        });

        this.accountCreateWindow.getClearButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleClearClick();
            }
        });
    }

    private boolean validateAccountCreateInput(AccountDto accountDto) {
        // Need to implement the existence of customers from customer ID.
        // Read about using exceptions for validation.

        // Depending on the type of currency, the minimum amount should be changes.
        boolean isValidAmount = accountDto.getAmount() > 5000.0;
        boolean isSamePassword = accountDto.getPassword().equals(accountDto.getConfirmPassword());
        System.out.println(isValidAmount);
        System.out.println(isSamePassword);
        return isValidAmount && isSamePassword;
    }

    private void handleSaveClick() {
        try {
            AccountDto accountDto = mapInputsToAccountDto();
            if (validateAccountCreateInput(accountDto)) {

                new AccountOtpController(this.ACCOUNT_SERVICE.createAccountTesting(accountDto));
                JOptionPane.showMessageDialog(this.accountCreateWindow, "Account created successfully.");
            } else {
                throw new AccountCreateException("Invalid Input.");
            }
        } catch (AccountCreateException e) {
            JOptionPane.showMessageDialog(this.accountCreateWindow, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }

    private AccountDto mapInputsToAccountDto() {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountType((AccountType) this.accountCreateWindow.getAccountTypeCombo().getSelectedItem());
        accountDto.setAccountNumber(this.accountCreateWindow.getAccountNumberInput().getText());
        accountDto.setCurrency((String) this.accountCreateWindow.getCurrencyCombo().getSelectedItem());
        accountDto.setCustomerId(Integer.parseInt(this.accountCreateWindow.getCustomerIdInput().getText()));
        accountDto.setAmount(Double.parseDouble(this.accountCreateWindow.getAmountInput().getText()));
        accountDto.setPassword(String.valueOf(this.accountCreateWindow.getPasswordInput().getPassword()));
        accountDto.setConfirmPassword(String.valueOf(this.accountCreateWindow.getConfirmPasswordInput().getPassword()));
        return accountDto;
    }

    private void handleClearClick() {
        this.accountCreateWindow.getAccountNumberInput().setText("");
        this.accountCreateWindow.getAccountTypeCombo().setSelectedIndex(0);
        this.accountCreateWindow.getCurrencyCombo().setSelectedIndex(0);
        this.accountCreateWindow.getAmountInput().setText("");
        this.accountCreateWindow.getCustomerIdInput().setText("");
        this.accountCreateWindow.getPasswordInput().setText("");
        this.accountCreateWindow.getConfirmPasswordInput().setText("");
    }
}

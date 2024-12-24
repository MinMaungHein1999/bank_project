package controller;


import dto.AccountDto;
import exception.AccountCreateException;
import model.AccountType;
import service.AccountService;
import view.accounts.AccountCreateWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountCreateController extends BaseController{

    private final AccountService ACCOUNT_SERVICE = new AccountService();


    private static AccountCreateWindow accountCreateWindow;

    public AccountCreateController() {
        super(accountCreateWindow);
        accountCreateWindow = new AccountCreateWindow();
        accountCreateWindow.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSaveClick();
            }
        });

        accountCreateWindow.getClearButton().addActionListener(new ActionListener() {
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
                JOptionPane.showMessageDialog(accountCreateWindow, "Account created successfully.");
            } else {
                throw new AccountCreateException("Invalid Input.");
            }
        } catch (AccountCreateException e) {
            JOptionPane.showMessageDialog(accountCreateWindow, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }

    private AccountDto mapInputsToAccountDto() {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountType((AccountType) accountCreateWindow.getAccountTypeCombo().getSelectedItem());
        accountDto.setAccountNumber(accountCreateWindow.getAccountNumberInput().getText());
        accountDto.setCurrency((String) accountCreateWindow.getCurrencyCombo().getSelectedItem());
        accountDto.setCustomerId(Integer.parseInt(accountCreateWindow.getCustomerIdInput().getText()));
        accountDto.setAmount(Double.parseDouble(accountCreateWindow.getAmountInput().getText()));
        accountDto.setPassword(String.valueOf(accountCreateWindow.getPasswordInput().getPassword()));
        accountDto.setConfirmPassword(String.valueOf(accountCreateWindow.getConfirmPasswordInput().getPassword()));
        return accountDto;
    }

    private void handleClearClick() {
        accountCreateWindow.getAccountNumberInput().setText("");
        accountCreateWindow.getAccountTypeCombo().setSelectedIndex(0);
        accountCreateWindow.getCurrencyCombo().setSelectedIndex(0);
        accountCreateWindow.getAmountInput().setText("");
        accountCreateWindow.getCustomerIdInput().setText("");
        accountCreateWindow.getPasswordInput().setText("");
        accountCreateWindow.getConfirmPasswordInput().setText("");
    }
}
